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
     * Complete the 'kaprekarNumbers' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER p
     *  2. INTEGER q
     */

    public static void kaprekarNumbers(int p, int q) {
        StringBuilder sb = new StringBuilder();

        for (int number = p; number <= q; number++) {
            int numSize = String.valueOf(number).length();
            long numPow = (long) Math.pow(number, 2);
            int numPowSize = String.valueOf(numPow).length();
            String numPowStr = String.valueOf(numPow);
            String rightSubs = numPowStr.substring(numPowSize - numSize, numPowSize);
            String leftSubs = numPowStr.substring(0, numPowSize - numSize);

            if (numPowSize == 1 && number == numPow)
                sb.append(number).append(" ");

            else if (numPowSize > 1 && Long.parseLong(rightSubs) + Long.parseLong(leftSubs) == number)
                sb.append(number).append(" ");

        }
        System.out.println(sb.toString().length() == 0 ? "INVALID RANGE" : sb.toString());
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        Result.kaprekarNumbers(p, q);

        bufferedReader.close();
    }
}
