package arihon.chapter2.section3.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/abc083/tasks/arc088_a
 * solved: https://atcoder.jp/contests/dp/submissions/11644867
 */
public class DP_A {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] hArr = new int[n];
        for (int i = 0; i < n; i++) {
            hArr[i] = sc.nextInt();
        }

        int[] dp = new int[n + 10];
        dp[0] = 0;
        dp[1] = Math.abs(hArr[1] - hArr[0]);
        for (int i = 0; i < n - 2; i++) {
            dp[i + 2] = Math.min(dp[i] + Math.abs(hArr[i] - hArr[i + 2]), dp[i + 1] + Math.abs(hArr[i + 1] - hArr[i + 2]));
        }
        //debug(dp);
        System.out.println(dp[n - 1]);
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new DP_A().run();
    }
}
