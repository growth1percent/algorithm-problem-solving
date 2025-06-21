import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] sArray = br.readLine().split(" ");

            int num_0 = Integer.parseInt(sArray[0]);
            int num_1 = Integer.parseInt(sArray[1]);

            list.add(new int[] {num_0, num_1});
        }

        Collections.sort(list, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });

        for (int[] values : list) {
            System.out.println(values[0] + " " + values[1]);
        }
    }
}