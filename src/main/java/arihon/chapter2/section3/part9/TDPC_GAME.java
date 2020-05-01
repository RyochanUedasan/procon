package arihon.chapter2.section3.part9;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/abc021/tasks/abc021_d
 * solved: https://atcoder.jp/contests/abc021/submissions/12291195
 */
public class TDPC_GAME {

    void run() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] aArr = new int[a];
        int[] bArr = new int[b];

        for (int i = 0; i < a; i++) {
            aArr[i] = sc.nextInt();
        }
        for (int i = 0; i < b; i++) {
            bArr[i] = sc.nextInt();
        }

        // dp[l][r] ... 左の山からl個、右の山からr個とったときの価値の合計の最大値
        int[][] dp = new int[a + 1][b + 1];
        for (int l = a; l >= 0; l--) {
            for (int r = b; r >= 0; r--) {
                if (l == a && r == b) continue;

                if ((l + r) % 2 == 0) {
                    if (l == a) {
                        dp[l][r] = dp[l][r + 1] + bArr[r];
                    } else if (r == b) {
                        dp[l][r] = dp[l + 1][r] + aArr[l];
                    } else {
                        dp[l][r] = Math.max(dp[l + 1][r] + aArr[l], dp[l][r + 1] + bArr[r]);
                    }
                } else {
                    if (l == a) {
                        dp[l][r] = dp[l][r + 1];
                    } else if (r == b) {
                        dp[l][r] = dp[l + 1][r];
                    } else {
                        dp[l][r] = Math.min(dp[l + 1][r], dp[l][r + 1]);
                    }
                }
            }
        }
//        debug(dp);
        System.out.println(dp[0][0]);
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new TDPC_GAME().run();
    }
}
