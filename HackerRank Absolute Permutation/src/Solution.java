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
     * Complete the 'absolutePermutation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     */

    public static List<Integer> absolutePermutation(int n, int k) {
        List<Integer> resultList = new ArrayList<>(Collections.nCopies(n, -1));
        Set<Integer> set = new HashSet<>();
        System.out.println(resultList);

        if (k == 0) {
            for (int i = 1; i <= n; i++) {
                resultList.set(i - 1, i);
            }
            return resultList;
        }

        for (int i = 1; i <= n; i++) {
            int lowValue = i - k;
            int upValue = i + k;

            if (lowValue > 0 && !set.contains(lowValue)) {
                resultList.set(i - 1, lowValue);
                set.add(lowValue);
            } else if (upValue <= n && !set.contains(upValue)) {
                resultList.set(i - 1, upValue);
                set.add(upValue);
            } else {
                return Collections.singletonList(-1);
            }
        }
        return resultList;

//        for (Integer integer : intList) {
//            int lowValue = integer - k;
//            int upValue = integer + k;
//
//            if (lowValue > 0 && !resultList.contains(lowValue)) {
//                resultList.add(lowValue);
//            } else if (upValue <= n)
//                resultList.add(upValue);
//            else return Collections.singletonList(-1);
//            //System.out.println("Lower " + lowValue + " " + " Upper " + upValue);
//        }

//        for (int i = 1; i <= n ; i++) {
//            for (int j = 1; j <= n ; j++) {
//                if(Math.abs(j - i) == k && !resultList.contains(j)) {
//                    resultList.add(j);
//                    break;
//                }
//            }
//        }

        //System.out.println(resultList);
        //System.out.println(Arrays.toString(intList));

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

                int n = Integer.parseInt(firstMultipleInput[0]);

                int k = Integer.parseInt(firstMultipleInput[1]);

                List<Integer> result = Result.absolutePermutation(n, k);
                System.out.println(result);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
