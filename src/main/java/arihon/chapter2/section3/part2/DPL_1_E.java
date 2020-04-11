package arihon.chapter2.section3.part2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=DPL_1_E&lang=jp
 * solved: http://judge.u-aizu.ac.jp/onlinejudge/review.jsp?rid=4343768#1
 */
public class DPL_1_E {

    void run() {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int n1 = s1.length();
        int n2 = s2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int[] x : dp) {
            Arrays.fill(x, Integer.MAX_VALUE);
        }
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n2; j++) {
            dp[0][j] = j;
        }
//        debug(dp);
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                dp[i + 1][j + 1] =
                        Math.min(
                                Math.min(dp[i + 1][j] + 1, dp[i][j + 1] + 1),
                                dp[i][j] + (s1.charAt(i) == s2.charAt(j) ? 0 : 1)
                        );
            }
        }
//        debug(dp);

        System.out.println(dp[n1][n2]);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new DPL_1_E().run();
    }
}
