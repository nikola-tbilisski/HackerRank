import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        if(obstacles.isEmpty())
            return queenAttackSquares(r_q, c_q, n);

        return queenAttackSquares(r_q, c_q, n) - blockedSquares(n, r_q, c_q, obstacles);
    }

    public static int queenAttackSquares(int queenX, int queenY, int boardSize) {
        int orthogonal = 2 * boardSize - 2;
        int diagonal = 2 * boardSize - 2 - Math.abs(queenX - queenY) - Math.abs(queenX + queenY - boardSize - 1);

        return orthogonal + diagonal;
    }

    public static int blockedSquares(int n, int r_q, int c_q, List<List<Integer>> obstacles) {
        Set<List<Integer>> blockedCells = new HashSet<>();
        for (List<Integer> obs : obstacles) {
            int x = obs.get(0);
            int y = obs.get(1);
            String position = getRelativeLocations(r_q, c_q, x, y);

            switch (position) {
                case "U":
                    for (int i = x; i <= n; i++)
                        blockedCells.add(Arrays.asList(i, y));
                    continue;

                case "D":
                    for (int i = x; i >= 1; i--)
                        blockedCells.add(Arrays.asList(i, y));
                    continue;

                case "L":
                    for (int i = y; i >= 1; i--)
                        blockedCells.add(Arrays.asList(x, i));
                    continue;

                case "R":
                    for (int i = y; i <= n; i++)
                        blockedCells.add(Arrays.asList(x, i));
                    continue;

                case "UL":
                    while (x <= n && y >= 1) {
                        blockedCells.add(Arrays.asList(x, y));
                        x++;
                        y--;
                    }
                    continue;

                case "UR":
                    while (x <= n && y <= n) {
                        blockedCells.add(Arrays.asList(x, y));
                        x++;
                        y++;
                    }
                    continue;

                case "DR":
                    while (x >= 1 && y <= n) {
                        blockedCells.add(Arrays.asList(x, y));
                        x--;
                        y++;
                    }
                    continue;

                case "DL":
                    while (x >= 1 && y >= 1) {
                        blockedCells.add(Arrays.asList(x, y));
                        x--;
                        y--;
                    }
                    continue;

            }
        }
        //System.out.println(blockedCells);

        return blockedCells.size();
    }

    public static String getRelativeLocations(int queenX, int queenY, int obsX, int obsY) {
        if (obsX == queenX && obsY < queenY) return "L";
        if (obsX == queenX && obsY > queenY) return "R";
        if (obsY == queenY && obsX > queenX) return "U";
        if (obsY == queenY && obsX < queenX) return "D";

        if (Math.abs(queenX - obsX) == Math.abs(queenY - obsY)) {
            if (obsX > queenX && obsY < queenY) return "UL";
            if (obsX > queenX && obsY > queenY) return "UR";
            if (obsX < queenX && obsY > queenY) return "DR";
            if (obsX < queenX && obsY < queenY) return "DL";
        }
        return "";
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);

        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                obstacles.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.queensAttack(n, k, r_q, c_q, obstacles);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
