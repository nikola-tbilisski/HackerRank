import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

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
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> resultList = new ArrayList<>();

        //HackerRank mathematical solution
        if (grades.size() >= 1 && grades.size() <= 60) {
            for (Integer grade : grades) {
                if (grade >= 38) {
                    int mod5 = grade % 5;
                    if (mod5 >= 3) {
                        resultList.add(grade + 5 - mod5);
                    } else resultList.add(grade);
                } else resultList.add(grade);
            }
        }
        System.out.println(resultList);

        // my Solution
//        if (grades.size() >= 1 && grades.size() <= 60) {
//            for (Integer grade : grades) {
//                if (grade >= 0 && grade <= 100) {
//                    if (grade >= 38) {
//                        int gradeTmp = grade;
//                        for (int i = gradeTmp; ; i++) {
//                            if (i % 5 == 0) {
//                                if (i - gradeTmp < 3) {
//                                    resultList.add(i);
//                                } else {
//                                    resultList.add(grade);
//                                }
//                                break;
//                            }
//                        }
//                    } else {
//                        resultList.add(grade);
//                    }
//                }
//            }
//        }
//        System.out.println(resultList);

        return resultList;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.gradingStudents(grades);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
