import java.io.*;
import java.lang.reflect.Array;
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
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
        List<Integer> highScoreL = new LinkedList<>();
        List<Integer> lowestScoreL = new LinkedList<>();
        int scoresHigh = scores.get(0);
        int scoresLow = scores.get(0);
        int highScoreCount = 0;
        int lowScoreCount = 0;

//        for (Integer score : scores) {
//            if (scoresHigh >= score) {
//                highScoreL.add(scoresHigh);
//            } else {
//                highScoreCount++;
//                scoresHigh = score;
//                highScoreL.add(score);
//            }
//
//            if (scoresLow <= score) {
//                lowestScoreL.add(scoresLow);
//            } else {
//                lowScoreCount++;
//                scoresLow = score;
//                lowestScoreL.add(scoresLow);
//            }
//        }
        for(Integer score : scores) {
            if(scoresHigh < score) {
                highScoreCount++;
                scoresHigh = score;
            }

            if(scoresLow > score) {
                lowScoreCount++;
                scoresLow = score;
            }
        }

        //System.out.println(lowestScoreL);
        //System.out.println(highScoreCount + " " + lowScoreCount);

        return Arrays.asList(highScoreCount, lowScoreCount);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.collectingAndThen(toList(), list -> {
                    if (list.size() != n) throw new RuntimeException("Wrong number of elements");
                    return list;
                }));

        List<Integer> result = Result.breakingRecords(scores);
        System.out.println(result);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
