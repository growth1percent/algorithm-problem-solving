import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < num; i++) {
            String line = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            String[] target = line.split(" ");
            int iterNum = Integer.parseInt(target[0]);
            String s = target[1];
            int s_len = s.length();

            for (int j = 0; j < s_len; j++) {
                char c = s.charAt(j);
                for (int k = 0; k < iterNum; k++) {
                    sb.append(c);
                }
            }

            System.out.println(sb.toString());
        }
    }
}

