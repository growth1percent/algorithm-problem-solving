import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[] array = br.readLine().split(" ");
        int[] nums = new int[array.length];
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int n = Integer.parseInt(array[i]);
            nums[i] = n;
        }

        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int sub = M - sum;
                    if (sum <= M && sub < min) {
                        min = sub;
                        result = sum;
                    }
                }
            }
        }

        System.out.println(result);
    }
}