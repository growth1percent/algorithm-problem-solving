import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        L = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[] nums = new int[L];

        for (int i = 0; i < L; i++) {
            nums[i] = s.charAt(i) - 'a' + 1;
        }

        long hashSum = 0;
        long mod = 1234567891;
        long pow = 1;

        for (int i = 0; i < nums.length; i++) {
            hashSum = (hashSum + ((long) nums[i] * pow) % mod) % mod;
            pow = (pow * 31) % mod;
        }

        System.out.println(hashSum);
    }
}