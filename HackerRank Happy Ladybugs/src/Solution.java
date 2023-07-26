import javafx.scene.web.WebHistory;

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
     * Complete the 'happyLadybugs' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING b as parameter.
     */

    public static String happyLadybugs(String b) {
        String answer = "YES";

        Map<Character, Long> map = b.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (Map.Entry<Character, Long> entry : map.entrySet()) {
            if (!entry.getKey().toString().matches("[A-Z]")
                    && !entry.getKey().toString().matches("_")) answer = "NO";
            else if (entry.getKey().toString().matches("[A-Z]") && entry.getValue() < 2) answer = "NO";
            else if (entry.getKey().toString().matches("[A-Z]") && !map.containsKey('_') && entry.getValue() > 1) {
                for (int i = 1; i < b.length() - 1; i++) {
                    if (b.charAt(i) != b.charAt(i + 1)
                            && b.charAt(i) != b.charAt(i - 1)
                            || b.charAt(b.length() - 1) != b.charAt(b.length() - 2)) {
                        answer = "NO";
                        break;
                    }
                }
            }
        }

        //map.forEach((k, v) -> System.out.println(k + " " + v));

        return answer;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, g).forEach(gItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                String b = bufferedReader.readLine();

                String result = Result.happyLadybugs(b);
                System.out.println(result);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
