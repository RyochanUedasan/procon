package arihon.chapter2.section3.part2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=DPL_1_E&lang=jp
 * solved: http://judge.u-aizu.ac.jp/onlinejudge/review.jsp?rid=4343768#1
 */
public class INDEEDNOW_2015_FINALA_C {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][][] dp = new int[102][102][102];

        for (int i = 0; i < n; i++) {
            // ここが絶妙。いつもなら1スタートなのにスコアが0を含む
            int a = sc.nextInt() + 1;
            int b = sc.nextInt() + 1;
            int c = sc.nextInt() + 1;
            dp[a][b][c] = Math.max(dp[a][b][c], sc.nextInt());
        }

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                for (int k = 0; k < 101; k++) {
                    dp[i + 1][j + 1][k + 1] = Math.max(dp[i + 1][j + 1][k + 1], dp[i + 1][j + 1][k]);
                    dp[i + 1][j + 1][k + 1] = Math.max(dp[i + 1][j + 1][k + 1], dp[i + 1][j][k + 1]);
                    dp[i + 1][j + 1][k + 1] = Math.max(dp[i + 1][j + 1][k + 1], dp[i][j + 1][k + 1]);
                }
            }
        }

//        debug(dp);
        for (int i = 0; i < m; i++) {
            System.out.println(dp[sc.nextInt() + 1][sc.nextInt() + 1][sc.nextInt() + 1]);
        }


    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new INDEEDNOW_2015_FINALA_C().run();
    }
}
