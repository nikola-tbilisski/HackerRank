import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    static boolean isAnagram(String a, String b) {
//        Map<Character, Long> aCharsFreqMap =
//                a.toLowerCase().chars()
//                        .mapToObj(c -> (char) c)
//                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//        Map<Character, Long> bCharsFreqMap =
//                b.toLowerCase().chars()
//                        .mapToObj(c -> (char) c)
//                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//        aCharsFreqMap.forEach((k, v) -> System.out.println("Key " + k + " Value " + v));
//        System.out.println();
//        bCharsFreqMap.forEach((k, v) -> System.out.println("Key " + k + " Value " + v));
//
//        return aCharsFreqMap.equals(bCharsFreqMap);

        char[] aChars = a.toLowerCase().toCharArray();
        char[] bChars = b.toLowerCase().toCharArray();
        Arrays.sort(aChars);
        Arrays.sort(bChars);

        if (aChars.length != bChars.length) return false;

        for (int i = 0; i < aChars.length; i++) {
            if (aChars[i] != bChars[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}
