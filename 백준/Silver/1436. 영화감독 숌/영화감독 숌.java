import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int count = 0;
        int num = 666;

        while (true) {
            if (String.valueOf(num).contains("666")) {
                count++;
                if (count == N) {
                    System.out.println(num);
                    break;
                }
            }
            num++;
        }
    }
}