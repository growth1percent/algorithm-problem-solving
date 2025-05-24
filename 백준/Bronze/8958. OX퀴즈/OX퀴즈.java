import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_num = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < test_num; i++) {
            String s = sc.nextLine();
            int consNum = 0;
            int score = 0;

            for (int j = 0; j < s.length(); j++) {
                char c  = s.charAt(j);
                if (c == 'O') {
                    consNum++;
                    score += consNum;
                } else {
                    consNum = 0;
                }
            }
            System.out.println(score);
        }
    }
}