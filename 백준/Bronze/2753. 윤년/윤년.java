import java.util.*;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int target = sc.nextInt();
       int answer = 0;

       if (target % 4 == 0) {
           if (target % 100 != 0 || target % 400 == 0) {
               answer = 1;
           } else {
               answer = 0;
           }
       } else {
           answer = 0;
       }

       System.out.println(answer);
    }
}