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
    private static final int MIN_PASSWORD_LENGTH = 6;
    private static final int REQUIRED_COMPONENTS = 4;

    /*
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */

    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        Matcher symbol = Pattern
                .compile("([A-Z])|([a-z])|([0-9])|([!@#$%^&*()\\-+])")
                .matcher(password);
        Set<Integer> groupSet = new HashSet<>();

        while (symbol.find()) {
            for (int i = 1; i <= symbol.groupCount(); i++) {
                if (symbol.group(i) != null) {
                    groupSet.add(i);
                }
            }
        }

        int count = groupSet.size();

        int symbolToAdd = 4 - count;

        if (n + symbolToAdd < 6)
            return 6 - (n + symbolToAdd) + symbolToAdd;
        else
            return symbolToAdd;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);
        System.out.println(answer);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
