import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < 3; i++) {
            String input = sc.next() + " " + sc.next();
            String[] arr = input.replaceAll("\\s+$", "").split(" ");
            map.put(arr[0], Integer.parseInt(arr[1]));
        }
        System.out.println("================================");
        for (Map.Entry<String, Integer> mp : map.entrySet()) {
            System.out.printf("%-15s%03d", mp.getKey(), mp.getValue());
            System.out.println();
        }
        System.out.println("================================");
    }
}



