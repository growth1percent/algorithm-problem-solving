import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[N];
        int[] result = new int[N];
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                int index = stack.pop();
                result[index] = A[i];
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            result[index] = -1;
        }

        for (int i = 0; i < N; i++) {
            bw.write(result[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}