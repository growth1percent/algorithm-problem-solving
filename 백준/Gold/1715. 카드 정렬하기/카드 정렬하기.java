import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;

        while (pq.size() > 1) {
            int set1 = pq.remove();
            int set2 = pq.remove();

            sum += set1 + set2;
            pq.add(set1 + set2);
        }

        System.out.println(sum);
    }
}
