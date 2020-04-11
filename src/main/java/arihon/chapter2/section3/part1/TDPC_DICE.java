package arihon.chapter2.section3.part1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/tdpc/tasks/tdpc_contest
 * solved: https://atcoder.jp/contests/tdpc/submissions/11714533
 */
public class TDPC_DICE {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long d = sc.nextLong();
        int count5 = 0;
        int count2 = 0;
        int count3 = 0;
        while (d % 5 == 0) {
            d = d / 5;
            count5++;
        }
        while (d % 2 == 0) {
            d = d / 2;
            count2++;
        }
        while (d % 3 == 0) {
            d = d / 3;
            count3++;
        }
        if (d != 1) {
            System.out.println(0);
            return;
        }

//        debug(count2, count3, count5);


        // dp[i][j][k][l] ... iこサイコロを投げた時に、2がjこ、3がkこ、5がlこ出る確率。
        double[][][][] dp = new double[n + 1][count2 + 1][count3 + 1][count5 + 1];
        dp[0][0][0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= count2; j++) {
                for (int k = 0; k <= count3; k++) {
                    for (int l = 0; l <= count5; l++) {
                        dp[i + 1][Math.min(count2, j + 2)][k][l] += dp[i][j][k][l] / (double) 6; // 4
                        dp[i + 1][Math.min(count2, j + 1)][k][l] += dp[i][j][k][l] / (double) 6; // 2
                        dp[i + 1][j][Math.min(count3, k + 1)][l] += dp[i][j][k][l] / (double) 6; // 3
                        dp[i + 1][j][k][Math.min(count5, l + 1)] += dp[i][j][k][l] / (double) 6; // 5
                        dp[i + 1][Math.min(count2, j + 1)][Math.min(count3, k + 1)][l] += dp[i][j][k][l] / (double) 6; // 6
                        dp[i + 1][j][k][l] += dp[i][j][k][l] / (double) 6; // 1
                    }
                }
            }
        }

        System.out.println(dp[n][count2][count3][count5]);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new TDPC_DICE().run();
    }
}
