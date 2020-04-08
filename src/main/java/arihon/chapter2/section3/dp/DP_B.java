package arihon.chapter2.section3.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/abc083/tasks/arc088_a
 * solved: https://atcoder.jp/contests/dp/submissions/11646489
 */
public class DP_B {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] hArr = new int[n + 1000];
        for (int i = 0; i < n; i++) {
            hArr[i] = sc.nextInt();
        }

        int[] dp = new int[n + 1000];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + Math.abs(hArr[i] - hArr[i + j]));
            }
        }
        //debug(dp);
        System.out.println(dp[n - 1]);
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new DP_B().run();
    }
}
