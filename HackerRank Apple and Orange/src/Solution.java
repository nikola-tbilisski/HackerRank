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
     * Complete the 'countApplesAndOranges' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER s
     *  2. INTEGER t
     *  3. INTEGER a
     *  4. INTEGER b
     *  5. INTEGER_ARRAY apples
     *  6. INTEGER_ARRAY oranges
     */

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        //my second solution
        int appleCount = 0;
        int orangeCount = 0;

        for (Integer i : apples) {
            int apl = a + i;
            if (apl >= s && apl <= t)
                appleCount++;
        }

        for (Integer i : oranges) {
            int orn = b + i;
            if (orn >= s && orn <= t)
                orangeCount++;
        }

        System.out.println(appleCount + "\n" + orangeCount);

        //my first solution
//        List<Integer> appleDist = new ArrayList<>();
//        List<Integer> orangeDist = new ArrayList<>();
//
//        for (Integer i : apples) {
//            appleDist.add(a + i);
//        }
//
//        for (Integer i : oranges) {
//            orangeDist.add(b + i);
//        }
//
//        System.out.println(appleDist);
//        System.out.println(orangeDist);
//
//        int appleCounter = Math.toIntExact(appleDist.stream()
//                .filter(el -> el >= s && el <= t)
//                .count());
//
//        int orangeCounter = Math.toIntExact(orangeDist.stream()
//                .filter(el -> el >= s && el <= t)
//                .count());
//
//        System.out.println(appleCounter + "\n" + orangeCounter);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int s = Integer.parseInt(firstMultipleInput[0]);

        int t = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int a = Integer.parseInt(secondMultipleInput[0]);

        int b = Integer.parseInt(secondMultipleInput[1]);

        String[] thirdMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(thirdMultipleInput[0]);

        int n = Integer.parseInt(thirdMultipleInput[1]);

        List<Integer> apples = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                    if (list.size() != m) throw new RuntimeException("Wrong number of elements");
                    return list;
                }));

        List<Integer> oranges = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                    if (list.size() != n) throw new RuntimeException("Wrong number of elements");
                    return list;
                }));

        Result.countApplesAndOranges(s, t, a, b, apples, oranges);

        bufferedReader.close();
    }
}
