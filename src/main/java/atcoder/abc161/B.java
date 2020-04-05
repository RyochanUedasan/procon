package atcoder.abc161;

import java.util.*;

public class B {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            int x = total % (4 * m) == 0 ?  total / (4 * m) : total / (4 * m) + 1;
            if (arr[i] >= x) {
                count++;
            }
        }
//        debug(count);

        System.out.println(count >= m ? "Yes" : "No");

    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
