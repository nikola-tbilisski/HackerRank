import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'chocolateFeast' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER c
     *  3. INTEGER m
     */

    //My first Solution
//    public static int chocolateFeast(int n, int c, int m) {
//        int initBars = n / c;
//        int initWrappers = initBars;
//        int result = initBars;
//
//        if (initWrappers < m) return result;
//        else if (initWrappers == m) return result + 1;
//        else {
//            //int result = initBars;
//            while (initWrappers >= m) {
//                int bars = initWrappers / m;
//                initWrappers -= m * bars;
//                result += bars;
//                initWrappers += bars;
//            }
//        }
//        return result;
//    }

    //My second Solution, suggested by chatGPT
    public static int chocolateFeast(int totalMoney, int costPerChocolate, int wrappersNeeded) {
        if (totalMoney < costPerChocolate) return 0;
        int initialBars = totalMoney / costPerChocolate;
        int initialWrappers = totalMoney / costPerChocolate;
        int result = initialBars;

        while (initialWrappers >= wrappersNeeded) {
            int barsFromWrappers = initialWrappers / wrappersNeeded;
            initialWrappers = initialWrappers % wrappersNeeded + barsFromWrappers;
            result += barsFromWrappers;
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int c = Integer.parseInt(firstMultipleInput[1]);

                int m = Integer.parseInt(firstMultipleInput[2]);

                int result = Result.chocolateFeast(n, c, m);
                System.out.println(result);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
