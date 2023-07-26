import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'bomberMan' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY grid
     */

    public static List<String> bomberMan(int n, List<String> grid) {
        List<List<Integer>> indices = getBombIndices(grid);
        //System.out.println(indices);
        //System.out.println(indices.get(0));

        List<String> bombsGrid = new ArrayList<>(Collections.nCopies(grid.size(), grid.get(0).replaceAll("\\.", "O")));
        int rows = bombsGrid.size();
        int cols = bombsGrid.get(0).length();

        //bombsGrid.forEach(System.out::println);
        //System.out.println();

        if (n == 1)
            return grid;

        if (n % 2 == 0)
            return bombsGrid;

        n /= 2;

        for (int i = 1; i <= (n + 1) % 2 + 1; i++) {
            bombsGrid = new ArrayList<>(Collections.nCopies(grid.size(), grid.get(0).replaceAll("\\.", "O")));
            for (List<Integer> index : indices) {
                int rowInd = index.get(0);
                int colInd = index.get(1);

                int left = colInd - 1;
                int right = colInd + 1;
                int up = rowInd - 1;
                int down = rowInd + 1;

                StringBuilder sb = new StringBuilder(bombsGrid.get(rowInd));
                sb.setCharAt(colInd, '.');
                bombsGrid.set(rowInd, sb.toString());

                if (left >= 0 && bombsGrid.get(rowInd).charAt(left) != '.') {
                    sb.setCharAt(left, '.');
                    bombsGrid.set(rowInd, sb.toString());
                }
                if (down < rows && bombsGrid.get(down).charAt(colInd) != '.') {
                    StringBuilder sbDown = new StringBuilder(bombsGrid.get(down));
                    sbDown.setCharAt(colInd, '.');
                    bombsGrid.set(down, sbDown.toString());
                }
                if (right < cols && bombsGrid.get(rowInd).charAt(right) != '.') {
                    sb.setCharAt(right, '.');
                    bombsGrid.set(rowInd, sb.toString());
                }
                if (up >= 0 && bombsGrid.get(up).charAt(colInd) != '.') {
                    StringBuilder sbUp = new StringBuilder(bombsGrid.get(up));
                    sbUp.setCharAt(colInd, '.');
                    bombsGrid.set(up, sbUp.toString());
                }
            }
            indices = getBombIndices(bombsGrid);
        }

        return new ArrayList<>(bombsGrid);
    }

    private static List<List<Integer>> getBombIndices(List<String> grid) {
        List<List<Integer>> indices = new ArrayList<>();

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(0).length(); j++) {
                if (grid.get(i).charAt(j) == 'O') {
                    indices.add(Arrays.asList(i, j));
                }
            }
        }
        return indices;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);

        int c = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = IntStream.range(0, r).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Result.bomberMan(n, grid);
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
