import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            int count = 0;
//            String line;
//            StringBuilder sb = new StringBuilder();
//
//            while (!Objects.equals(line = reader.readLine(), "")) {
//                //System.out.println(++count + " " + line);
//                String l = ++count + " " + line + "\n";
//                sb.append(l);
//            }
//            System.out.println(sb);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = 0;
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(++count + " " + line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}