import java.io.*;
import java.util.*;

public class Main {
    static class Document {
        int idx;
        int rank;

        Document(int idx, int rank) {
            this.idx = idx;
            this.rank = rank;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Deque<Document> queue = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                int rank = Integer.parseInt(st.nextToken());
                queue.add(new Document(i, rank));
            }

            int order = 0;
            while (!queue.isEmpty()) {
                Document current = queue.pollFirst();
                int idx = current.idx;
                int rank = current.rank;

                boolean hasHigher = false;

                for (Document doc : queue) {
                    if (doc.rank > rank) {
                        hasHigher = true;
                        break;
                    }
                }

                if (hasHigher) {
                    queue.addLast(current);
                } else {
                    order++;
                    if (idx == M) {
                        break;
                    }
                }
            }

            System.out.println(order);
        }
    }
}