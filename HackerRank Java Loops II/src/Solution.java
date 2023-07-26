import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String[] abnStrArr;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            String abn = in.next() + " " + in.next() + " " + in.next();
            abnStrArr = abn.replaceAll("\\s+$", "").split(" ");
            int a = Integer.parseInt(abnStrArr[0]);
            int b = Integer.parseInt(abnStrArr[1]);
            int n = Integer.parseInt(abnStrArr[2]);
            int fs = a + ((int) Math.pow(2, 0)) * b;
            sb.append(fs);
            //System.out.println(fs);
            for (int j = 1; j < n; j++) {
                fs += ((int) Math.pow(2, j)) * b;
                sb.append(" ").append(fs);
                //System.out.println(fs);
            }
            sb.append("\n");
        }
        System.out.println(sb);

        in.close();
    }
}