import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        List<String[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            list.add(new String[] {s[0], s[1], String.valueOf(i)});
        }

        Collections.sort(list, (a, b) -> {
            int aAge = Integer.parseInt(a[0]);
            int bAge = Integer.parseInt(b[0]);

            int aNum = Integer.parseInt(a[2]);
            int bNum = Integer.parseInt(b[2]);

            if (aAge == bAge) {
                return aNum - bNum;
            } else {
                return aAge - bAge;
            }
        });

        for (String[] people : list) {
            System.out.println(people[0] + " " + people[1]);
        }
    }
}