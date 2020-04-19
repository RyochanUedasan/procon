package arihon.chapter2.section3.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/dp/tasks/dp_m
 * solved: https://atcoder.jp/contests/dp/submissions/11940496
 */
public class DP_M {
    void run() {
        Scanner sc = new Scanner(System.in);
        long MOD = (long) 1e9 + 7;
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // dp[i][j] .. i番目の子供でj個の飴を分け合う方法の総数
        long[][] dp = new long[N + 1][K + 1];

        dp[0][0] = 1;

        for (int i = 0; i < N; i++) { // 10 ^ 2
            long[] cum = new long[K + 2];
            cum[0] = dp[i][0];
            for (int j = 0; j <= K; j++) {
                cum[j + 1] = (cum[j] + dp[i][j]) % MOD;
            }
//            debug(cum);
            for (int j = 0; j <= K; j++) {
                dp[i + 1][j] = (cum[j + 1] - cum[Math.max(0, j - arr[i])] + MOD) % MOD;
            }

            // これはTLE
//            for (int j = 1; j <= K; j++) { // 10 ^ 5
//                for (int k = 0; k <= arr[i]; k++) { // 10 ^ 5
//                    if (j - k >= 0) {
//                        dp[i + 1][j] += dp[i][j - k] % MOD;
//                    }
//                }
//            }

//            // これがダメな理由がいまいちわからん
//            for (int j = 1; j <= Math.min(sum, K); j++) { // 10 ^ 5
//                if (j - arr[i] >= 0) {
//                    // dp[i + 1][j] = dp[i][j] + dp[i][j - 1] + ... + dp[i][j - arr[i]];
//                    // dp[i + 1][j - 1] = dp[i][j - 1] + dp[i][j - 2] + ... + dp[i][j - arr[i] - 1];
//                    // 両辺引いて：
//                    dp[i + 1][j] = (dp[i][j] + dp[i][j - 1] - dp[i][j - arr[i] - 1]) % MOD;
//                } else {
//                    // dp[i + 1][j] = dp[i][j] + dp[i][j - 1] + ... + dp[i][0];
//                    // dp[i + 1][j - 1] = dp[i][j - 1] + dp[i][j - 2] + ... + dp[i][0];
//                    dp[i + 1][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
//                }
//            }
        }
        System.out.println(dp[N][K] % MOD);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new DP_M().run();
    }
}
