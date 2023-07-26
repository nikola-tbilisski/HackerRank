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
     * Complete the 'libraryFine' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER d1
     *  2. INTEGER m1
     *  3. INTEGER y1
     *  4. INTEGER d2
     *  5. INTEGER m2
     *  6. INTEGER y2
     */

    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
//        Calendar cal1 = new GregorianCalendar();
//        cal1.set(y1, m1, d1);
//        Calendar cal2 = new GregorianCalendar();
//        cal2.set(y2, m2, d2);
//
//        System.out.println(cal1.getTime());
//        System.out.println(cal2.getTime());

        if (d1 >= 1 && d1 <= 31 && d2 >= 1 && d2 <= 31
                && m1 >= 1 && m1 <= 12 && m2 >= 1 && m2 <= 12
                && y1 >= 1 && y1 <= 3000 && y2 >= 1 && y2 <= 3000) {
            if (y1 > y2) return 10000;
            else if (y2 > y1) return 0;

            if (m1 > m2) return (m1 - m2) * 500;
            else if(m2 > m1) return 0;

            if (d1 > d2) return (d1 - d2) * 15;
        }

        return 0;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d1 = Integer.parseInt(firstMultipleInput[0]);

        int m1 = Integer.parseInt(firstMultipleInput[1]);

        int y1 = Integer.parseInt(firstMultipleInput[2]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d2 = Integer.parseInt(secondMultipleInput[0]);

        int m2 = Integer.parseInt(secondMultipleInput[1]);

        int y2 = Integer.parseInt(secondMultipleInput[2]);

        int result = Result.libraryFine(d1, m1, y1, d2, m2, y2);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
