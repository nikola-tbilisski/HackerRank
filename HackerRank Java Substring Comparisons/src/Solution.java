import java.util.Scanner;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        for (int i = 1; i <= s.length() - k; i++) {
            String tmp = s.substring(i, k + i);
            largest = largest.compareTo(tmp) > 0 ? largest : tmp;
            smallest = smallest.compareTo(tmp) < 0 ? smallest : tmp;
        }

        return smallest + "\n" + largest;
    }

    static class Test {
        public static void main(String[] args) {
            System.out.println(Solution.getSmallestAndLargest("welcometojava", 3));
        }
    }
}

