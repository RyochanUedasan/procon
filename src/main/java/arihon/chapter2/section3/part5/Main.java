package arihon.chapter2.section3.part5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/arc057/tasks/arc057_b
 * solved: https://atcoder.jp/contests/arc057/submissions/11875889
 */
public class Main {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = 3;
        int[] a = {3, 5, 8};
        int[] m = {3, 2, 2};
        int K = 17;

//        // dp[i][j]  ... i種類の数でjという数を作れるかどうかのbool値
//        boolean[][] dp = new boolean[n + 1][K + 1];
//        dp[0][0] = true;
//        for (int i = 0; i < n; i++) { // 10^2
//            for (int j = 0; j <= K; j++) { // 10^5
//                for (int k = 0; k <= m[i]; k++) { // 10^5
//                    if (j - a[i] * k >= 0) {
//                        dp[i + 1][j] = dp[i + 1][j] || dp[i][j - a[i] * k];
//                    }
//                }
//            }
//        }

        // dp[i][j]  ... i種類の数でjを作る際に余る最大のi番目の個数（作れない場合は-1）
        int[][] dp = new int[n + 1][K + 1];
        dp[0][0] = 0;
//        for (int i = 0; i < n; i++) { // 10^2
//            for (int j = 0; j <= K; j++) { // 10^5
////                for (int k = 0; k <= m[i]; k++) { // 10^5
////                    if (j - a[i] * k >= 0) {
////                        dp[i + 1][j] = dp[i + 1][j] || dp[i][j - a[i] * k];
////                    }
////                }
//                if (dp[i][j] >= 0) {
//                    dp[i + 1][j] = m[i];
//                } else if (j < a[i] || dp[i + 1][j - a[i]] <= 0) {
//                    dp[i + 1][j] = -1;
//                } else {
//                    dp[i + 1][j] = dp[i + 1][j - a[i]] - 1;
//                }
//            }
//        }
//
////        debug(dp);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= K; j++) {
                if (dp[i][j] >= 0) {
                    dp[i + 1][j] = m[i];
                } else if (dp[i + 1][j - a[i]] <= 0 || j < a[i]) {
                    dp[i + 1][j] = -1;
                } else {
                    dp[i + 1][j] = dp[i + 1][j - a[i]] - 1;
                }
            }
        }
        System.out.println(dp[n][K]);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
