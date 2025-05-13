import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] array = line.split(" ");
            int a = Integer.parseInt(array[0]);
            int b = Integer.parseInt(array[1]);

            if (a == 0 && b == 0) break;

            System.out.println(a+b);
        }
    }
}

