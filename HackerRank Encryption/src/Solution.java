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
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
        String text = s.replaceAll("\\s+", "");
        int length = text.length();

        int rows = (int) Math.floor(Math.sqrt(length));
        int columns = (int) Math.ceil(Math.sqrt(length));

        if (rows * columns < length) rows++;

        //char[][] sChars = new char[rows][columns];

        StringBuilder result = new StringBuilder();
        System.out.println(text);

//        for (int i = 0; i < columns; i++) {
//            int step = 0;
//            while (i + step < length) {
//                result.append(text.charAt(i + step));
//                step += columns;
//            }
//            result.append(" ");
//        }

        for (int i = 0; i < columns; i++) {
            for (int j = i; j < length; j += columns) {
                result.append(text.charAt(j));
            }
            result.append(" ");
        }


        System.out.println(length + " " + rows + " " + columns);

        return result.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);
        System.out.println(result);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
