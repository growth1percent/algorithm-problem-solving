import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] strArr = br.readLine().split("");

        int[] numArr = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
        
        int sum = 0;
        
        for (int i = 0; i < numArr.length; i++) {
            sum += numArr[i];
        }
        
        System.out.println(sum);
    }
}