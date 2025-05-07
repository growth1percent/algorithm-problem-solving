import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int a = sc.nextInt();
            int idx = 0;

            while (idx < a) {
                for (int i = 0; i <= idx; i++) {
                    System.out.print("*");
                }
                System.out.print("\n");
                idx++;
            }
    }
}