package arihon.chapter2.section3.part8;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem:
 * solved:
 */
public class Main {

    void run() {
        int n = 3;
        int m = 3;
        int[] arr = {1, 2, 3};
        int M = 10000;

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0 ; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j - arr[i] - 1 >= 0) {
                    dp[i + 1][j] = dp[i + 1][j - 1] - dp[i][j - arr[i] - 1] + dp[i][j];
                } else {
                    dp[i + 1][j] = dp[i + 1][j - 1] + dp[i][j];
                }
            }
        }
        debug(dp);
        System.out.println(dp[n][m]);

    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
