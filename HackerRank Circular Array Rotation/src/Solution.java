import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'circularArrayRotation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER k
     *  3. INTEGER_ARRAY queries
     */

    public static List<Integer> circularArrayRotationLinkedList(List<Integer> a, int k, List<Integer> queries) {
        long startTime = System.currentTimeMillis();
        if (k > a.size()) k = k % a.size();
        LinkedList<Integer> rotQueue = IntStream.range(0, a.size() - k)
                .mapToObj(a::get)
                .collect(Collectors.toCollection(LinkedList::new));

        rotQueue.addAll(0, IntStream.range(a.size() - k, a.size())
                .mapToObj(a::get)
                .collect(toList()));
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Time consumed with LinkedList: " + elapsedTime + " ms");

        return queries.stream()
                .map(rotQueue::get)
                .collect(toList());
    }

    public static List<Integer> circularArrayRotationArrayList(List<Integer> a, int k, List<Integer> queries) {
        long startTime = System.currentTimeMillis();
        if (k > a.size()) k = k % a.size();
        List<Integer> rotList = IntStream.range(0, a.size() - k)
                .mapToObj(a::get)
                .collect(toList());
        //System.out.println(rotList);
        rotList.addAll(0, IntStream.range(a.size() - k, a.size())
                .mapToObj(a::get)
                .collect(toList()));
        //System.out.println(rotList);
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Time consumed with ArrayList: " + elapsedTime + " ms");

        return queries.stream()
                .map(rotList::get)
                .collect(toList());
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        int q = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> queries = IntStream.range(0, q).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> resultLinkedList = Result.circularArrayRotationLinkedList(a, k, queries);
        System.out.println("LinkedList method");
        resultLinkedList.forEach(System.out::println);

        List<Integer> resultArrayList = Result.circularArrayRotationArrayList(a, k, queries);
        System.out.println("\nArrayList method");
        resultArrayList.forEach(System.out::println);

        bufferedWriter.write(
                resultLinkedList.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
