import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int[] A = new int[s.length()];

        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(s.substring(i, i + 1));
        }

        for (int i = 0; i < A.length - 1; i++) {
            int Max = i;

            for (int j = i + 1; j < A.length; j++) {
                if (A[Max] < A[j]) {
                    Max = j;
                }
            }

            int temp = A[i];
            A[i] = A[Max];
            A[Max] = temp;
        }

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);
        }
    }
}