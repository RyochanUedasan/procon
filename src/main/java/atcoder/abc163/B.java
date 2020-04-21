package atcoder.abc163;

import java.util.*;

public class B {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += sc.nextInt();
        }

        System.out.println(sum > n ? "-1" : n - sum);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
