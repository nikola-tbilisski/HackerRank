import java.io.*;
import java.util.stream.IntStream;

class Result {
    // lexicographically next permutations
    /*
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */

    public static String biggerIsGreater(String w) {
        char[] wChars = w.toCharArray();

        int i = wChars.length - 1;
        while (i > 0 && wChars[i - 1] >= wChars[i]) i--;

        if (i <= 0) return "no answer";

        int j = wChars.length - 1;
        while (wChars[j] <= wChars[i - 1]) j--;

        char tmp = wChars[i - 1];
        wChars[i - 1] = wChars[j];
        wChars[j] = tmp;

        j = wChars.length - 1;
        while (i < j) {
            tmp = wChars[i];
            wChars[i] = wChars[j];
            wChars[j] = tmp;
            i++;
            j--;
        }

        return String.valueOf(wChars);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = Result.biggerIsGreater(w);
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
