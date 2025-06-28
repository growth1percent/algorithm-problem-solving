import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            set.add(s);
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();

            if (set.contains(input)) {
                result.add(input);
            }
        }

        Collections.sort(result);

        bw.write(result.size() + "\n");

        for (String s : result) {
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}