import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        List<String> str = Stream.of(s.replaceAll("\\s+$", "").split("[\\s!,?._'@]+"))
                .filter(el -> el.matches("[A-Za-z]+"))
                .collect(Collectors.toList());


        System.out.println(str.size());
        str.forEach(System.out::println);

        scan.close();
    }
}

