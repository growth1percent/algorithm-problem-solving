import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Data[] A = new Data[N];

        for (int i = 0; i < N; i++) {
            A[i] = new Data(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(A);

        int Max = 0;

        for (int i = 0; i < N; i++) {
            int count = A[i].index - i;
            if (Max < count) {
                Max = count;
            }
        }

        System.out.println(Max + 1);
    }

    static class Data implements Comparable<Data> {
        int value;
        int index;

        Data(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Data o) {
            return this.value - o.value;
        }
    }
}