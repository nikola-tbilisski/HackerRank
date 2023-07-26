import javafx.util.Pair;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'twoPluses' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY grid as parameter.
     */
    public static int twoPluses(List<String> grid) {
        Stack<Integer> plusAreas = new Stack<>();
        Stack<Set<Pair<Integer, Integer>>> pluses = new Stack<>();

        String[] gridArr = new String[grid.size()];
        for (int i = 0; i < grid.size(); i++) {
            gridArr[i] = grid.get(i);
        }

        int grid_size = gridArr.length;
        int grid_str_length = gridArr[0].length();


        for (int row = 1; row < grid_size - 1; row++) {
            for (int col = 1; col < grid_str_length - 1; col++) {
                if (gridArr[row].charAt(col) == 'G') {
                    int sum = 1;
                    int step = 1;
                    Set<Pair<Integer, Integer>> set1 = new HashSet<>();
                    set1.add(new Pair<>(row, col));
                    plusAreas.push(sum);
                    pluses.push(set1);
                    while (row + step <= grid_size - 1
                            && row - step >= 0
                            && col + step <= grid_str_length - 1
                            && col - step >= 0) {
                        if (gridArr[row + step].charAt(col) == 'G'
                                && gridArr[row - step].charAt(col) == 'G'
                                && gridArr[row].charAt(col + step) == 'G'
                                && gridArr[row].charAt(col - step) == 'G') {
                            set1.add(new Pair<>(row + step, col));
                            set1.add(new Pair<>(row - step, col));
                            set1.add(new Pair<>(row, col + step));
                            set1.add(new Pair<>(row, col - step));
                            sum += 4;
                            step += 1;
                            plusAreas.push(sum);
                            pluses.push(new HashSet<>(set1));
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < plusAreas.size() - 1; i++) {
            for (int j = i + 1; j < plusAreas.size(); j++) {
                if (Collections.disjoint(pluses.get(i), pluses.get(j))) {
                    result = Math.max(result, plusAreas.get(i) * plusAreas.get(j));
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

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int result = Result.twoPluses(grid);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

