package arihon.chapter2.section3.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/dp/tasks/dp_e
 * solved: https://atcoder.jp/contests/dp/submissions/11659680
 */
public class DP_E {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[] wArr = new int[n];
        int[] vArr = new int[n];

        int V_MAX = 100100;
        for (int i = 0; i < n; i++) {
            wArr[i] = sc.nextInt();
            vArr[i] = sc.nextInt();
        }

        long[][] dp = new long[n + 1][V_MAX];
        for (long[] x : dp) {
            Arrays.fill(x, Integer.MAX_VALUE);
        }
//        debug(dp);
        dp[0][0] = 0;
        // dp[i][j] ... i番目までの荷物をつかって、価値がjを達成するような重さの最小値

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < V_MAX; j++) {
                if (vArr[i] <= j) {
                    dp[i + 1][j] = Math.min(dp[i][j], dp[i][j - vArr[i]] + wArr[i]);
                } else {
                    dp[i + 1][j] = dp[i][j];
                }
            }
        }

//        debug(dp);
        int ans = 0;
        for (int i = 0; i < V_MAX; i++) {
//            debug(dp[n][i]);
            if (w >= dp[n][i]) {
                ans = i;
            }
        }

        System.out.println(ans);
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new DP_E().run();
    }
}
