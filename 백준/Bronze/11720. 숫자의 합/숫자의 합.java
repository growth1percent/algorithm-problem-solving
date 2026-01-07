import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String s = br.readLine();
        char[] arr = s.toCharArray();
        int sum = 0;
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] - '0';    
        }
        
        System.out.println(sum);
    }
}