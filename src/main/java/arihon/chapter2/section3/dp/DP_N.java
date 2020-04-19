package arihon.chapter2.section3.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/dp/tasks/dp_m
 * solved: https://atcoder.jp/contests/dp/submissions/11940496
 */
public class DP_N {
    int N;
    int[] arr;
    long[] cum;
    long[][] dp;

    void run() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        cum = new long[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            cum[i + 1] = cum[i] + arr[i];
        }
//        debug(arr);
//        debug(cum);

        // 逆から考える
        // 分解には分解前のスライムの大きさと等しいコストがかかる
        // dp[l][r] ... 区間[l, r]に相当するスライムが1匹にまとまっているとき、それを分解するために最小のコスト
        dp = new long[N + 1][N + 1];
        for (long[] x : dp) {
            Arrays.fill(x, -1);
        }

        System.out.println(rec(0, N - 1));
//        debug(dp);
    }

    long rec(int l, int r) {
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        if (l == r) {
            return 0;
        }

        long res;
        long fans = Long.MAX_VALUE;

        for (int m = l; m < r; m++) {
            fans = Math.min(fans, rec(l, m) + rec(m + 1, r));
        }

        res = fans + cum[r + 1] - cum[l];
        dp[l][r] = res;
        return res;
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new DP_N().run();
    }
}
