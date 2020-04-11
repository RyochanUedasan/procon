package arihon.chapter2.section3.part1;

import java.util.Arrays;
import java.util.Scanner;


/**
 * problem: https://atcoder.jp/contests/tdpc/tasks/tdpc_contest
 * solved: https://atcoder.jp/contests/tdpc/submissions/11708447
 */
public class TDPC_CONTEST {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] pArr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            pArr[i] = sc.nextInt();
            sum += pArr[i];
        }

        // dp[i][j] ... i番目までの数字でjが作れるかどうか
        boolean[][] dp = new boolean[n + 1][sum + 1];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j >= pArr[i]) {
                    dp[i + 1][j] = dp[i + 1][j] || dp[i][j - pArr[i]];
                }
                dp[i + 1][j] = dp[i + 1][j] || dp[i][j];
            }
        }

        int ans = 0;
        for (int i = 0; i <= sum; i++) {
            ans += dp[n][i] ? 1 : 0;
        }
//        debug(dp[n]);
        System.out.println(ans);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new TDPC_CONTEST().run();
    }
}
