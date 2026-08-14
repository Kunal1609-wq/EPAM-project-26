import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] points = new int[n];

        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
        }

        long prev2 = 0;
        long prev1 = 0;

        for (int i = 0; i < n; i++) {
            long take = prev2 + points[i];
            long skip = prev1;

            long current = Math.max(take, skip);

            prev2 = prev1;
            prev1 = current;
        }

        System.out.println(prev1);

        sc.close();
    }
}