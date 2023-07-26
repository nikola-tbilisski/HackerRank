import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

class Result {

    /*
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int migratoryBirdsStreams(List<Integer> arr) {
        // Write your code here

        Map<Integer, Integer> map = arr.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Function.identity()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(e -> e.getValue().size()))
                .map(el -> Collections.singletonMap(el.getKey(), el.getValue().size()))
                .orElseThrow(IllegalArgumentException::new);

        map.forEach((el1, el2) -> System.out.println(el1 + " " + el2));

        return arr.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Function.identity()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(e -> e.getValue().size()))
                .map(Map.Entry::getKey)
                .orElse(0);
    }

    public static int migrateMyBirdsCycles(List<Integer> arr) {
       Set<Integer> integerSet = new HashSet<>(arr);
       int maxFreqKey = 0;
       int freqCount = 0;

       for(Integer i : integerSet){
           int frequency = Collections.frequency(arr, i);

           if(frequency > freqCount) {
               maxFreqKey = i;
               freqCount = frequency;
           }
       }

        System.out.println(integerSet);

        return maxFreqKey;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.collectingAndThen(toList(), list -> {
                    if (list.size() != arrCount) throw new RuntimeException("Wrong number of elements");
                    return list;
                }));

        int result = Result.migratoryBirdsStreams(arr);
        System.out.println(result);

        int result2 = Result.migrateMyBirdsCycles(arr);
        System.out.println(result2);

        bufferedWriter.write(String.valueOf(result2));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
