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
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */

    public static int formingMagicSquare(List<List<Integer>> s) {
        List<Integer[]> mCubes = new ArrayList<Integer[]>() {{
            add(new Integer[]{8, 1, 6, 3, 5, 7, 4, 9, 2});
            add(new Integer[]{6, 1, 8, 7, 5, 3, 2, 9, 4});
            add(new Integer[]{4, 9, 2, 3, 5, 7, 8, 1, 6});
            add(new Integer[]{2, 9, 4, 7, 5, 3, 6, 1, 8});
            add(new Integer[]{8, 3, 4, 1, 5, 9, 6, 7, 2});
            add(new Integer[]{4, 3, 8, 9, 5, 1, 2, 7, 6});
            add(new Integer[]{6, 7, 2, 1, 5, 9, 8, 3, 4});
            add(new Integer[]{2, 7, 6, 9, 5, 1, 4, 3, 8});
        }};

        Integer[] sToArray = IntStream.range(0, 3)
                .flatMap(i -> IntStream.range(0, 3).map(j -> s.get(i).get(j)))
                .boxed()
                .toArray(Integer[]::new);

        //mCubes.forEach(el -> System.out.println(Arrays.toString(el)));
        //Arrays.stream(sToArray).forEach(System.out::println);
        System.out.println(s);
        System.out.println(Arrays.toString(sToArray));

        return mCubes.stream()
                .mapToInt(mCubesEl -> IntStream.range(0, 9)
                        .map(i -> Math.abs(sToArray[i] - mCubesEl[i]))
                        .sum())
                .min()
                .orElse(0);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> s = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.formingMagicSquare(s);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
