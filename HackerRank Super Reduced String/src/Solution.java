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
     * Complete the 'superReducedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String superReducedString(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        int end = sb.length() - 1;

        while (i < end && sb.length() != 2) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb.deleteCharAt(i);
                sb.deleteCharAt(i);
                end -= 2;
                if (i > 0) {
                    i--;
                }
            } else {
                i++;
            }
        }

        if (sb.length() == 0 || sb.length() == 2 && sb.charAt(0) == sb.charAt(1))
            return "Empty String";

        return sb.toString();
//        StringBuilder sb = new StringBuilder(s);
//        int i = 0;
//        int end = sb.length() - 1;
//
//        while (i < end && sb.length() != 2) {
//            if (sb.charAt(i) == sb.charAt(i + 1)) {
//                sb.deleteCharAt(i);
//                sb.deleteCharAt(i);
//                end -= 2;
//            } else if (i > 0 && sb.charAt(i) == sb.charAt(i - 1)) {
//                sb.deleteCharAt(i);
//                sb.deleteCharAt(i - 1);
//                end -= 2;
//                i--;
//            } else {
//                i++;
//            }
//        }
//
//        if (sb.length() == 0 || sb.length() == 2 && sb.charAt(0) == sb.charAt(1))
//            return "Empty String";
//
//        return sb.toString();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.superReducedString(s);
        System.out.println(result);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
