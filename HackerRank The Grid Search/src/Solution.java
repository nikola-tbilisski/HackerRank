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
     * Complete the 'gridSearch' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY G
     *  2. STRING_ARRAY P
     */

    public static String gridSearch(List<String> G, List<String> P) {
        String answer = "NO";
        int pInd = 0;

        for (int gInd = 0; gInd < G.size(); gInd++) {
            String gLine = G.get(gInd);

            // Check if the current line of G contains the first line of P
            int startInd = gLine.indexOf(P.get(0));
            while (startInd >= 0) {
                // Check if the remaining lines of P match the corresponding lines of G
                pInd = 1;
                while (pInd < P.size() && (gInd + pInd) < G.size()) {
                    String gNextLine = G.get(gInd + pInd);
                    if (!gNextLine.substring(startInd).startsWith(P.get(pInd))) {
                        break;
                    }
                    pInd++;
                }

                // If all lines of P match, set answer to "YES" and break out of the loop
                if (pInd == P.size()) {
                    answer = "YES";
                    break;
                }

                // Otherwise, continue searching for matches on the same line of G
                startInd = gLine.indexOf(P.get(0), startInd + 1);
            }

            // Reset pInd after each line of G
            pInd = 0;
        }

        return answer;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int R = Integer.parseInt(firstMultipleInput[0]);

                int C = Integer.parseInt(firstMultipleInput[1]);

                List<String> G = IntStream.range(0, R).mapToObj(i -> {
                            try {
                                return bufferedReader.readLine();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        })
                        .collect(toList());

                String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int r = Integer.parseInt(secondMultipleInput[0]);

                int c = Integer.parseInt(secondMultipleInput[1]);

                List<String> P = IntStream.range(0, r).mapToObj(i -> {
                            try {
                                return bufferedReader.readLine();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        })
                        .collect(toList());

                String result = Result.gridSearch(G, P);
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
