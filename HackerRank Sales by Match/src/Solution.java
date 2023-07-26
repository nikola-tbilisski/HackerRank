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
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        int result = 0;
        Map<Integer, Integer> hMap = new HashMap<>();

        //My second Solution
        for (Integer el : ar) {
            hMap.put(el, Collections.frequency(ar, el));
        }

        for (Integer el : hMap.values()) {
            if (el > 1) {
                result += el / 2;
            }
        }

        //HackerRank solution
//        for (Integer el : ar) {
//            if (!hMap.containsKey(el)) {
//                hMap.put(el, 1);
//            } else {
//                hMap.put(el, hMap.get(el) + 1);
//            }
//        }
//
//        for (Integer el : hMap.values()) {
//            if (el > 1) {
//                result += el / 2;
//            }
//        }

        //my solution
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < ar.size(); i++) {
//            if (ar.get(i) != null && !map.containsKey(ar.get(i))) {
//                int indexI = i;
//                map.put(ar.get(i), ar.stream()
//                        .filter(el -> Objects.equals(el, ar.get(indexI)))
//                        .collect(Collectors.toList()));
//            }
//        }
//
//        for (List<Integer> el : map.values()) {
//            if (el.size() > 1) {
//                if (el.size() % 2 == 0) {
//                    result += el.size() / 2;
//                } else {
//                    result += (el.size() - 1) / 2;
//                }
//            }
//        }

        hMap.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println(result);

        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
