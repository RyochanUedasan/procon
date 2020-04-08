package arihon.chapter2.section3.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/dp/tasks/dp_c
 * solved: https://atcoder.jp/contests/dp/submissions/11646489
 */
public class DP_C {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n + 10][3];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()};
        }

        int[][] dp = new int[n + 10][3];
        // dp[i][j] ... i日目にjをする場合に得られる最大の幸福度 => ans = Max(dp[n][0..2])
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (j == k) continue;
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][k] + arr[i][j]);
                }
            }
        }
//        debug(dp);
        int ans = Math.max(Math.max(dp[n][0], dp[n][1]), dp[n][2]);
        System.out.println(ans);

    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new DP_C().run();
    }
}
