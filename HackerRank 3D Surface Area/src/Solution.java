import com.sun.javafx.collections.MappingChange;

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
     * Complete the 'surfaceArea' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY A as parameter.
     */

    public static int surfaceArea(List<List<Integer>> A) {
        //GeeksForGeeks solution
        int height = A.size();
        int width = A.get(0).size();
        int totalArea = 2 * (height * width);

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                /* If we are traveling the topmost
                row in the matrix, we declare the
                wall above it as 0 as there is no
                wall above it. */
                int up = 0;

                /* If we are traveling the leftmost
                column in the matrix, we declare the
                wall left to it as 0as there is no
                wall left it. */
                int left = 0;

                // If its not the topmost row
                if (row > 0) up = A.get(row - 1).get(col);

                // If its not the leftmost column
                if (col > 0) left = A.get(row).get(col - 1);

                // Summing up the contribution of by
                // the current block
                totalArea += Math.abs(A.get(row).get(col) - up)
                        + Math.abs(A.get(row).get(col) - left);

                /* If its the rightmost block of the matrix
                it will contribute area equal to its height
                as a wall on the right of the figure */
                if (row == height - 1)
                    totalArea += A.get(row).get(col);

                /* If its the lowest block of the
                matrix it will contribute area equal
                to its height as a wall on
                 the bottom of the figure */
                if (col == width - 1)
                    totalArea += A.get(row).get(col);
            }
        }
        return totalArea;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int H = Integer.parseInt(firstMultipleInput[0]);

        int W = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> A = new ArrayList<>();

        IntStream.range(0, H).forEach(i -> {
            try {
                A.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.surfaceArea(A);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
