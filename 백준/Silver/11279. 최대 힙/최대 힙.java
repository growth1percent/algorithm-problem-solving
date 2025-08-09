import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (!maxHeap.isEmpty()) {
                    bw.write(maxHeap.poll() + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            } else {
                maxHeap.add(num);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}