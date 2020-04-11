package arihon.chapter2.section3.part1;

import java.util.Arrays;
import java.util.Scanner;


/**
 * problem: http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=DPL_1_B
 * solved: http://judge.u-aizu.ac.jp/onlinejudge/review.jsp?rid=4331385#1
 */
public class DPL_1_B {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[] vArr = new int[n];
        int[] wArr = new int[n];

        for (int i = 0; i < n; i++) {
            vArr[i] = sc.nextInt();
            wArr[i] = sc.nextInt();
        }

        // dp[i][j] ... i番目までの品物で重さwをこえないような最大の価値
        // => 答えはdp[n][w]

        int[][] dp = new int[n + 1][w + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
//                debug(i, j ,dp);
                if (wArr[i] > j) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - wArr[i]] + vArr[i]);
                }
            }
        }
        System.out.println(dp[n][w]);

    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new DPL_1_B().run();
    }
}
