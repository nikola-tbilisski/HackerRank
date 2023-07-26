import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'cavityMap' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    //Solution with substring() method
//    public static List<String> cavityMap(List<String> grid) {
////        String[][] arrGrid = grid.stream()
////                .map(el -> new String[]{el})
////                .toArray(String[][]::new);
//
//        for (int row = 1; row < grid.size() - 1; row++) {
//            for (int chr = 1; chr < grid.get(row).length() - 1; chr++) {
//                if (grid.get(row).charAt(chr) > grid.get(row).charAt(chr - 1)
//                        && grid.get(row).charAt(chr) > grid.get(row).charAt(chr + 1)
//                        && grid.get(row).charAt(chr) > grid.get(row - 1).charAt(chr)
//                        && grid.get(row).charAt(chr) > grid.get(row + 1).charAt(chr)) {
//                    //System.out.println(grid.get(row).charAt(chr));
//                    grid.set(row, grid.get(row).substring(0, chr) + "X" + grid.get(row).substring(chr + 1));
//                }
//            }
//        }
//
//        //System.out.println(Arrays.deepToString(arrGrid));
//
//        return grid;
//    }

    //Solution with StringBuilder and copy of original List grid
    public static List<String> cavityMap(List<String> grid) {
        List<String> result = new ArrayList<>(grid); // create a copy of the original grid
        int rows = grid.size();
        int cols = grid.get(0).length();

        if (rows <= 2 || cols <= 2) { // handle edge cases
            return result;
        }

        for (int row = 1; row < rows - 1; row++) {
            for (int col = 1; col < cols - 1; col++) {
                if (grid.get(row).charAt(col) > grid.get(row).charAt(col - 1)
                        && grid.get(row).charAt(col) > grid.get(row).charAt(col + 1)
                        && grid.get(row).charAt(col) > grid.get(row - 1).charAt(col)
                        && grid.get(row).charAt(col) > grid.get(row + 1).charAt(col)) {
                    StringBuilder sb = new StringBuilder(result.get(row));
                    sb.setCharAt(col, 'X');
                    result.set(row, sb.toString());
                }
            }
        }

        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Result.cavityMap(grid);
        result.forEach(System.out::println);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
