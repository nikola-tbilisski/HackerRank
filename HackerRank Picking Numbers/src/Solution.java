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
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        //Collections.sort(a);
        int firstEl = a.get(0);
        int maxLength = 0;
        int count = 1;

        List<Integer> freqList = new ArrayList<>();

        for(int i = 0; i < 101; i++) {
            freqList.add(Collections.frequency(a, i));
        }

        System.out.println(freqList);

        for(int i = 1; i <= 100; i++){
            count = freqList.get(i) + freqList.get(i - 1);
            if(count > maxLength) maxLength = count;
        }

        //Wrong algorithm
//        for (int i = 1; i < a.size(); i++) {
//            if (Math.abs(firstEl - a.get(i)) <= 1) {
//                count++;
//            } else {
//                firstEl = a.get(i);
//                count = 1;
//            }
//            if (count > maxLength) maxLength = count;
//        }

        return maxLength;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.pickingNumbers(a);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
