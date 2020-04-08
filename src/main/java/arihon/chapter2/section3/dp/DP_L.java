package arihon.chapter2.section3.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/dp/tasks/dp_l
 * solved: https://atcoder.jp/contests/dp/submissions/11707890
 */
public class DP_L {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        // dp[i][j] ... 区間[i, j)における、X-Yの値
        long[][] dp = new long[n + 1][n + 1];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len;
                boolean isFirst = (n - len) % 2 == 0;
                if (isFirst) {
                    dp[i][j] = Math.max(dp[i + 1][j] + arr[i], dp[i][j - 1] + arr[j - 1]);
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j] - arr[i], dp[i][j - 1] - arr[j - 1]);
                }
            }
        }

//        debug(dp);

        System.out.println(dp[0][n]);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new DP_L().run();
    }
}
