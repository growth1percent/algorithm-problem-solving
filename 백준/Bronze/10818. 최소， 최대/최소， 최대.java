import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int target = sc.nextInt();
        int max = target;
        int min = target;

        for (int i = 1; i < num; i++) {
            int comp = sc.nextInt();
            if (comp > max) {
                max = comp;
            }

            if (comp < min){
                min = comp;
            }
        }

        System.out.print(min + " " + max);
    }
}

