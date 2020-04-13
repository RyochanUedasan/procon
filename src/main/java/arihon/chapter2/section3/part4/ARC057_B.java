package arihon.chapter2.section3.part4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/arc057/tasks/arc057_b
 * solved: https://atcoder.jp/contests/arc057/submissions/11875889
 */
public class ARC057_B {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        long[] totalArr = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            totalArr[i] = sc.nextInt() + totalArr[i - 1];
        }

        if (totalArr[n] == k) {
            System.out.println(1);
            return;
        }

        // dp[i][j] ... i日目までで、j日機嫌の良い日があったときの、最小の勝った回数
        long[][] dp = new long[n + 1][n + 1];
        for (long[] x : dp) {
            Arrays.fill(x, Long.MAX_VALUE);
        }
        dp[1][0] = 0;
        dp[1][1] = 1;
        for (int i = 0; i < n; i++) {
            long count = totalArr[i + 1]  - totalArr[i];
            for (int j = 0; j < i; j++) {
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j]);
                if (dp[i][j] == Long.MAX_VALUE) {
                    continue;
                }
                long tmp = dp[i][j] * (count) / totalArr[i] + 1;
                if (count >= tmp) {
                    dp[i + 1][j + 1] = dp[i][j] + tmp;
                }
            }
        }
//        debug(dp);
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            if (dp[n][i] <= k) {
                ans = Math.max(ans, i);
            }
        }
        System.out.println(ans);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new ARC057_B().run();
    }
}
