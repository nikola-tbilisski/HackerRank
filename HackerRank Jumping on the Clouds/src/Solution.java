import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c, int k) {
//        int energy = 100;
//        if ((c.length >= 2 && c.length <= 25)
//                && (k >= 1 && k <= c.length)) {
//            for (int i = 0; i < c.length; i += k) {
//                int jump = c[(i + k) % c.length];
//                System.out.println(jump);
//                energy = jump == 1 ? energy - 3 : jump == 0 ? energy - 1 : energy;
//            }
//        }
//        return energy;
        int energy = 100;
        int jumps = 0;

        do {
            jumps += k;
            if (jumps >= c.length) jumps %= c.length;
            energy = c[jumps] == 1 ? energy - 3 : energy - 1;
        } while (jumps != 0);

        return energy;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c, k);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
