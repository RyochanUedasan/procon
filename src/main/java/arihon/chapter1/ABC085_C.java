package arihon.chapter1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/arc061/tasks/arc061_a
 * solved: https://atcoder.jp/contests/abc085/submissions/10666714
 */
public class ABC085_C {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int y = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                int k = n - j - i;
                if (10000 * i + 5000 * j + 1000 * k == y) {
                    System.out.println(i + " " + j + " " + k);
                    return;
                }
            }
        }
        System.out.println("-1 -1 -1");
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new ABC085_C().run();
    }

}
