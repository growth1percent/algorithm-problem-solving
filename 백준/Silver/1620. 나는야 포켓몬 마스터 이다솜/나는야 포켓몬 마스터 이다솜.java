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

        Map<String, Integer> map = new HashMap<>();
        String[] pokemons = new String[N + 1];

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();

            map.put(s, i);
            pokemons[i] = s;
        }

        for (int i = 0; i < M; i++) {
            String target = br.readLine();

            boolean isNum = isNumeric(target);

            if (isNum) {
                int num = Integer.parseInt(target);
                String result = pokemons[num];
                bw.write(result + "\n");
            } else {
                int num = map.get(target);
                bw.write(num + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
    static boolean isNumeric(String target) {
        char c = target.charAt(0);

        if (Character.isDigit(c)) {
            return true;
        }

        return false;
    }
}