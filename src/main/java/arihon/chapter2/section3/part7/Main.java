package arihon.chapter2.section3.part7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem:
 * solved:
 */
public class Main {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = 4;
        int m = 3;
        int M = 10000;

        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 1;
        // dp[i][j] ... jのi分割の総数
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j - i >= 0) {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - i]) % M;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        debug(dp[0]);
        debug(dp);
        System.out.println(dp[m][n]);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
