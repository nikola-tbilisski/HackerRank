import java.io.*;
import java.math.*;
import java.security.*;
import java.sql.SQLOutput;
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
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER p
     */

    public static int pageCount(int n, int p) {
        //int[][] pagesArr = new int[n / 2 + 1][2];
        int elIndex = 0;
        int firstPage = 0;
        int lastPage = n / 2;

        for (int i = 0; i < n / 2 + 1; i++) {
            int x = i * 2;
            int y = x + 1;

            //pagesArr[i] = new int[]{x, y > n ? 0 : y};

            if(x == p || y == p) elIndex = i;

        }

//        Arrays.stream(pagesArr).forEach(el -> System.out.println(Arrays.toString(el)));
//        System.out.println(elIndex);
//        System.out.println("First Page " + firstPage + " " + lastPage);
        return Math.min(elIndex - firstPage, lastPage - elIndex);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.pageCount(n, p);

        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
