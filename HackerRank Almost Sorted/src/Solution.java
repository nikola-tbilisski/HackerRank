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
     * Complete the 'almostSorted' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void almostSorted(List<Integer> arr) {
        List<Integer> sortedArr = new ArrayList<>(arr);
        sortedArr.sort(null);
        int startInd = -1;
        int endInd = -1;
        int count = 0;
        int length = sortedArr.size();

        if (arr.equals(sortedArr)) System.out.println("yes");

        for (int i = 0; i < length; i++) {
            if (!Objects.equals(sortedArr.get(i), arr.get(i))) {
                if (startInd == -1) startInd = i;
                else endInd = i;
                count++;
            }
        }

        if (count == 2) {
            if ((startInd == 0 && endInd - startInd == 1) ||
                    (endInd == length - 1 && endInd - startInd == 1) ||
                    (startInd > 0 && endInd == length - 1 && arr.get(endInd) > arr.get(startInd - 1)) ||
                    (arr.get(startInd) < arr.get(endInd + 1) && arr.get(endInd) > arr.get(startInd - 1))) {
                System.out.println("yes\nswap " + (startInd + 1) + " " + (endInd + 1));
                return;
            }
            System.out.println("no");
            return;
        }

        if (count > 2) {
            for (int i = startInd; i < endInd; i++) {
                if(arr.get(i) < arr.get(i + 1)) {
                    System.out.println("no");
                    return;
                }
            }
            
            if ((startInd == 0 && endInd == length - 1) ||
                    ((startInd == 0 && endInd + 1 < length) && arr.get(startInd) < arr.get(endInd + 1)) ||
                    ((endInd == length - 1 && arr.get(endInd) > arr.get(startInd - 1))) ||
                    (arr.get(endInd) > arr.get(startInd - 1) && arr.get(startInd) < arr.get(endInd + 1))) {
                System.out.println("yes\nreverse " + (startInd + 1) + " " + (endInd + 1));
                return;
            }
            System.out.println("no");
        }

//        System.out.println("start " + startInd + " end " + endInd + " count " + count);
//
//        System.out.println(arr);
//        System.out.println(sortedArr);

        System.out.println("no");

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.almostSorted(arr);

        bufferedReader.close();
    }
}
