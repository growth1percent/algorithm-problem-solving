import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int min = sc.nextInt();
        int result_min = 0;
        int result_hour = 0;

        if (min < 45) {
            result_min = 60 - (45 - min);
            if (hour == 0) {
                result_hour = 23;
            } else {
                result_hour = hour - 1;
            }
        } else {
            result_hour = hour;
            result_min = min - 45;
        }

        System.out.print(result_hour + " " + result_min);
    }
}