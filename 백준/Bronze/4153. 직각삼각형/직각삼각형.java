import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            if (s.equals("0 0 0")) return;

            String[] array = s.split(" ");
            int[] nums = new int[3];
            for (int i = 0; i < 3; i++) {
                nums[i] = Integer.parseInt(array[i]);
            }
            Arrays.sort(nums);

            int a = nums[0];
            int b = nums[1];
            int c = nums[2];

            int sum = (int) (Math.pow(a, 2) + Math.pow(b, 2));
            int target = (int) (Math.pow(c, 2));

            if (sum == target) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}