import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

class Result {

    /*
     * Complete the 'minimumDistances' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    // How to get indexes of all duplicate elements by using java stream
    // reduce()
    // orElse()
    public static int minimumDistances(List<Integer> a) {

        // O(n^2) worst case time complexity with stream api
//        return IntStream.range(0, a.size())
//                .boxed()
//                .collect(Collectors.groupingBy(a::get, HashMap::new,
//                        Collectors.toCollection(ArrayList::new)))
//                .values()
//                .stream()
//                .filter(integers -> integers.size() > 1)
//                .map(integers -> integers.stream().reduce(0, (el1, el2) -> Math.abs(el1 - el2)))
//                .min(Comparator.naturalOrder())
//                .orElse(-1);

        // O(n) worst case time complexity with HashMap
        Map<Integer, Integer> lastPos = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < a.size(); i++) {
            int num = a.get(i);
            if (lastPos.containsKey(num)) {
                int distance = i - lastPos.get(num);
                minDistance = Math.min(minDistance, distance);
            }
            lastPos.put(num, i);
        }

        //lastPos.forEach((k, v) -> System.out.println(k + " " + v));

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.minimumDistances(a);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
