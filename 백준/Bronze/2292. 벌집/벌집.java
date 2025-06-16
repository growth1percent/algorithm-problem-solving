import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int num = 1;
        int floor = 1;

        while (N > num) {
            num += floor * 6;
            floor++;
        }
        System.out.println(floor);
    }
}