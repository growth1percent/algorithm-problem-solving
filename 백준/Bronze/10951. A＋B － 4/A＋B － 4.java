import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] array = line.split(" ");
            int a = Integer.parseInt(array[0]);
            int b = Integer.parseInt(array[1]);

            System.out.println(a+b);
        }
    }
}

