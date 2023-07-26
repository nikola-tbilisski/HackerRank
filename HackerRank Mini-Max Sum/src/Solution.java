import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        List<Long> longList = arr.stream()
                .map(Long::valueOf)
                .collect(toList());

//        for(Integer i : arr){
//            longList.add(Long.valueOf(i));
//        }

        if (longList.size() == 5) {
            Collections.sort(longList);
            System.out.println(longList);
            Long minSum = longList.stream().reduce(-longList.get(arr.size() - 1), Long::sum);
            Long maxSum = longList.stream().reduce(-longList.get(0), Long::sum);
            System.out.println("Sum all elements except last: " + minSum + " " +
                    "\nSum all elements except first: " + maxSum);
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
