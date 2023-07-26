import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

class Result {

    /*
     * Complete the 'designerPdfViewer' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h
     *  2. STRING word
     */

    public static int designerPdfViewer(List<Integer> h, String word) {
        // My solution
//        List<Character> alphabet = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
//                'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
//                'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
//        Map<Character, Integer> charMap = IntStream.range(0, alphabet.size())
//                .boxed()
//                .collect(toMap(alphabet::get, h::get));
//        int maxHeight = 0;
//        //charMap.forEach((k, v) -> System.out.println(k + " " + v));
//
//        for (char w : word.toCharArray()) {
//            for (char cm : charMap.keySet()) {
//                if (w == cm) {
//                    if (charMap.get(cm) > maxHeight) {
//                        maxHeight = charMap.get(cm);
//                    }
//                }
//            }
//        }
//
//        return maxHeight * word.length();

        //HackerRank solution
        int maxHeight = 0;

        for (int i = 0; i < word.length(); i++) {
            int charAti = word.charAt(i);
            int aValue = 'a';
            maxHeight = Math.max(maxHeight, h.get(word.charAt(i) - 'a'));
        }
        return maxHeight * word.length();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String word = bufferedReader.readLine();

        int result = Result.designerPdfViewer(h, word);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
