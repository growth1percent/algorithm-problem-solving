import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String target = sc.nextLine();
        int num = sc.nextInt();

        char result = target.charAt(num - 1);

        System.out.print(result);
    }
}

