import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next().toLowerCase();
        String B = sc.next().toLowerCase();
        /* Enter your code here. Print output to STDOUT. */
        int sum = A.length() + B.length();
        String compareStr = A.compareTo(B) > 0 ? "Yes" : "No";
        String aCap = A.substring(0, 1).toUpperCase() + A.substring(1);
        String bCap = B.substring(0, 1).toUpperCase() + B.substring(1);

        System.out.println(sum + "\n" + compareStr + "\n" + aCap + " " + bCap);

    }
}



