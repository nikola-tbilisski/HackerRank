import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        /* Enter your code here. Print output to STDOUT. */
        StringBuilder rev = new StringBuilder();

        for (int i = A.length() - 1; i >= 0; i--) {
            rev.append(A.toLowerCase().charAt(i));
        }

        System.out.println(rev.toString().equals(A.toLowerCase()) ? "Yes" : "No");

//        if (rev.toString().equals(A.toLowerCase())) System.out.println("Yes");
//        else System.out.println("No");
    }
}



