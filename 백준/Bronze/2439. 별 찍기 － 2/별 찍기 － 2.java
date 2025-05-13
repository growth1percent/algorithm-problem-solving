import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int iterNum = n - i - 1;
            int iterNum2 = i + 1;
            while (iterNum > 0) {
                sb.append(" ");
                iterNum--;
            }
            while (iterNum2 > 0) {
                sb.append("*");
                iterNum2--;
            }

            System.out.println(sb);
        }
    }
}

