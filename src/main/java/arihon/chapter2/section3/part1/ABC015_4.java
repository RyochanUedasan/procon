package arihon.chapter2.section3.part1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/abc015/tasks/abc015_4
 * solved: https://atcoder.jp/contests/abc015/submissions/11724092
 */
public class ABC015_4 {

    void run() {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int n = sc.nextInt();
        int K = sc.nextInt();
        int[] aArr = new int[n];
        int[] bArr = new int[n];
        for (int i = 0; i < n; i++) {
            aArr[i] = sc.nextInt();
            bArr[i] = sc.nextInt();
        }

        // dp[i][j][k] ... i番目までのスクリーンショットを使って、幅jになる、かつk枚しか使っていない時の最大の重要度
        int[][][] dp = new int[n + 1][w + 1][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                for (int k = 0; k <= i; k++) {
                    if (aArr[i] <= j) {
                        dp[i + 1][j][k + 1] = Math.max(dp[i][j][k + 1], dp[i][j - aArr[i]][k] + bArr[i]);
                    } else {
                        dp[i + 1][j][k] = dp[i][j][k];
                    }
                }
            }
        }
        int ans = 0;
        for (int j = 0; j <= w; j++) {
            for (int k = 0; k <= K; k++) {
                ans = Math.max(ans, dp[n][j][k]);
            }
        }
        System.out.println(ans);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new ABC015_4().run();
    }
}
