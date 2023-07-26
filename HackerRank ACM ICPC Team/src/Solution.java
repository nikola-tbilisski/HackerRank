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
     * Complete the 'acmTeam' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY topic as parameter.
     */

    public static List<Integer> acmTeam(List<String> topic) {
        int max = 0;
        int teams = 1;

        for (int i = 0; i < topic.size(); i++) {
            for (int j = i + 1; j < topic.size(); j++) {
                int bits = countBits(topic.get(i), topic.get(j));
                System.out.println(bits);
                if (bits > max) {
                    max = bits;
                    teams = 1;
                } else if (bits == max) teams++;
            }
        }

        return new ArrayList<>(Arrays.asList(max, teams));
    }

    public static int countBits(String str1, String str2) {
        int countOnes = 0;
        int strLength = str1.length();

        for (int i = 0; i < strLength; i++) {
            if (str1.charAt(i) == '1' || str2.charAt(i) == '1') countOnes++;
        }
        return countOnes;
    }

}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> topic = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<Integer> result = Result.acmTeam(topic);
        System.out.println(result);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
