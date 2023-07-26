import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int maxA = Collections.max(a);
        int minB = Collections.min(b);
        int result = 0;

        for (int i = maxA; i <= minB; i++) {
            boolean factorOrMultiple = true;

            for (Integer ai : a) {
                if (i % ai != 0) {
                    factorOrMultiple = false;
                    break;
                }
            }

            for (Integer bi : b) {
                if (bi % i != 0) {
                    factorOrMultiple = false;
                    break;
                }
            }
            if (factorOrMultiple) {
                System.out.print(i + " ");
                result++;
            }
        }
        System.out.println();
        return result;
    }

    public static int myGetTotalX(List<Integer> a, List<Integer> b) {
        int maxA = Collections.max(a);
        int minB = Collections.min(b);

//        List<Integer> lcmList = IntStream.range(maxA, minB + 1)
//                .boxed()
//                .collect(toList());

        List<Integer> resultList = IntStream.range(maxA, minB + 1)
                .boxed()
                .filter(lcm -> (a.stream().allMatch(aList -> (lcm % aList == 0))))
                .filter(lcm -> b.stream().allMatch(bList -> bList % lcm == 0))
                .collect(toList());


//        System.out.println(lcmList);
        System.out.println(resultList);

        return resultList.size();
    }

    public static void measureTime(Runnable task) {
        long startTime = System.currentTimeMillis();
        task.run();
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Elapsed time: " + elapsedTime + " ms");
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                    if (list.size() != n) throw new RuntimeException("Wrong number of elements");
                    return list;
                }));

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                    if (list.size() != m) throw new RuntimeException("Wrong number of elements");
                    return list;
                }));
        AtomicInteger total1 = new AtomicInteger();
        AtomicInteger total2 = new AtomicInteger();

        System.out.println("getTotalX() with for loops");
        Result.measureTime(() ->  total1.set(Result.getTotalX(arr, brr)));
        System.out.println(total1 +"\n");

        System.out.println("myGetTotalX() with stream api");
        Result.measureTime(() -> total2.set(Result.myGetTotalX(arr, brr)));
        System.out.println(total2);

        bufferedWriter.write(String.valueOf(total1));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
