import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] parts = input.split("-");
        int result = sum(parts[0]);

        for (int i = 1; i < parts.length; i++) {
            result -= sum(parts[i]);
        }

        System.out.println(result);
    }

    static int sum(String str) {
        String[] nums = str.split("\\+");
        int total = 0;
        for (String num : nums) {
            total += Integer.parseInt(num);
        }
        return total;
    }
}