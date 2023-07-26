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
     * Complete the 'decryptMessage' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING encryptedMessage as parameter.
     */

    public static String decryptMessage(String encryptedMessage) {
        List<String> stringList = Arrays.asList(encryptedMessage.split(" "));
        Collections.reverse(stringList);
        StringBuilder sb = new StringBuilder(String.join(" ", stringList));

        for (int i = 0; i < sb.length(); i++) {
            if (Character.isDigit(sb.charAt(i)) && Integer.parseInt(String.valueOf(sb.charAt(i))) > 1) {
                int n = Integer.parseInt(String.valueOf(sb.charAt(i))) - 1;
                char[] charsToInsert = new char[n];
                System.out.println(n);
                for (int j = 0; j < n; j++) {
                    charsToInsert[j] = sb.charAt(i - 1);
                    System.out.println(charsToInsert);
                }
                sb.deleteCharAt(i);
                sb.insert(i, charsToInsert);
            }
        }

        return sb.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String encryptedMessage = bufferedReader.readLine();

        String result = Result.decryptMessage(encryptedMessage);
        System.out.println(result);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
