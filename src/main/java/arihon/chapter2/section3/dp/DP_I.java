package arihon.chapter2.section3.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/dp/tasks/dp_i
 * solved: https://atcoder.jp/contests/dp/submissions/11690215
 */
public class DP_I {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] pArr = new double[n];
        for (int i = 0; i < n; i++) {
            pArr[i] = sc.nextDouble();
        }

        // dp[i][j] ... コインをiマイ投げて、jマイ表が出る確率
        double[][] dp = new double[n + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = dp[i + 1][j + 1] + dp[i][j] * pArr[i];
                dp[i + 1][j] = dp[i + 1][j] + dp[i][j] * (1 - pArr[i]);
            }
        }
//        debug(dp);
        double ans = 0;
        for (int i = n; i > n / 2; i--) {
            ans += dp[n][i];
        }
        System.out.println(ans);
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new DP_I().run();
    }
}
