import java.io.*;
import java.util.*;

public class Solution {
    static {
        Scanner sc = new Scanner(System.in);
        final int height = sc.nextInt();
        final int breadth = sc.nextInt();

        try {
            if (height > 0 && breadth > 0) System.out.println(height * breadth);
            else throw new Exception("Breadth and height must be positive");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}