import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (!minHeap.isEmpty()) {
                    bw.write(minHeap.poll() + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            } else {
                minHeap.add(num);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}