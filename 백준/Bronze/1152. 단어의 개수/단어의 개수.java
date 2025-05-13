import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String[] words = s.strip().split("\\s+");

        if (words.length == 1 && words[0].isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(words.length);
        }
    }
}

