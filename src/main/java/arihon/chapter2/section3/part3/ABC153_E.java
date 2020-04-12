package arihon.chapter2.section3.part3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/abc153/tasks/abc153_e
 * solved:
 */
public class ABC153_E {

    void run() {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int n = sc.nextInt();

        int[] aArr = new int[n];
        int[] bArr = new int[n];

        for (int i = 0; i < n; i++) {
            aArr[i] = sc.nextInt();
            bArr[i] = sc.nextInt();
        }

        // dp[j] ... 体力をj減らす時の最小の魔力
        int[] dp = new int[h + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 0; i <= h; i++) {
            for (int j = 0; j < n; j++) {
                dp[i] = Math.min(dp[i], dp[Math.max(i - aArr[j], 0)] + bArr[j]);
            }
        }

//        debug(dp);
        System.out.println(dp[h]);

    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new ABC153_E().run();
    }
}
