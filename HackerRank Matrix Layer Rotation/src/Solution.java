import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'matrixRotation' function below.
     *
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY matrix
     *  2. INTEGER r
     */

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
//        int[][] matArray = matrix.stream().map(row -> row.stream().mapToInt(el -> el).toArray()).toArray(int[][]::new);
//        Arrays.stream(matArray).forEach(el -> System.out.println(Arrays.toString(Arrays.stream(el).toArray())));
        List<List<Integer>> layersMat = getLayers(matrix);
        layersMat.forEach(System.out::println);
        int layers = layersMat.size();
        int row = matrix.size();
        int col = matrix.get(0).size();
        int[][] resultMat = new int[row][col];

        for (int i = 0; i < layers; i++) {
            List<Integer> layerRow = layersMat.get(i);
            int index = r % layerRow.size();

            for (int j = i; j < col - 1 - i; j++) {
                resultMat[i][j] = layerRow.get(index);
                index = (index + 1) % layerRow.size();
            }
            for (int j = i; j < row - 1 - i; j++) {
                resultMat[j][col - 1 - i] = layerRow.get(index);
                index = (index + 1) % layerRow.size();
            }
            for (int j = col - 1 - i; j > i; j--) {
                resultMat[row - 1 - i][j] = layerRow.get(index);
                index = (index + 1) % layerRow.size();
            }
            for (int j = row - 1 - i; j > i; j--) {
                resultMat[j][i] = layerRow.get(index);
                index = (index + 1) % layerRow.size();
            }
            //System.out.println(index + " " + layerRow.size());
        }
        //Arrays.stream(resultMat).forEach(el -> System.out.println(Arrays.toString(el)));
        printMat(resultMat);
    }
    private static List<List<Integer>> getLayers(List<List<Integer>> matrix) {
        List<List<Integer>> mat = new ArrayList<>();
        int layers = Math.min(matrix.size(), matrix.get(0).size()) / 2;
        int row = matrix.size();
        int col = matrix.get(0).size();

        for (int i = 0; i < layers; i++) {
            List<Integer> tmp_mat = new ArrayList<>();
            for (int j = i; j < col - 1 - i; j++) {
                tmp_mat.add(matrix.get(i).get(j));
            }
            for (int j = i; j < row - 1 - i; j++) {
                tmp_mat.add(matrix.get(j).get(col - 1 - i));
            }
            for (int j = col - 1 - i; j > i; j--) {
                tmp_mat.add(matrix.get(row - 1 - i).get(j));
            }
            for (int j = row - 1 - i; j > i; j--) {
                tmp_mat.add(matrix.get(j).get(i));
            }

            mat.add(tmp_mat);
            //tmp_mat.forEach(el -> System.out.print(el + " "));
        }
        //System.out.println(matrix.size() + " " + matrix.get(0).size() + " Layer count " + layers);
        return mat;
    }

    private static void printMat(int[][] resultMat) {
        for (int[] i : resultMat) {
            for (Integer in : i) {
                System.out.print(in + " ");
            }
            System.out.println();
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
