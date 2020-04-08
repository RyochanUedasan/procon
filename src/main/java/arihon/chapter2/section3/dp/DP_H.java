package arihon.chapter2.section3.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * problem: https://atcoder.jp/contests/dp/tasks/dp_h
 * solved: https://atcoder.jp/contests/dp/submissions/11689656
 */
public class DP_H {

    void run() {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        long MOD = (long) 1e9 + 7;
        boolean[][] field = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            char[] cs = sc.next().toCharArray();
            for (int j = 0; j < w; j++) {
                field[i][j] = cs[j] == '.';
            }
        }

        long[][] dp = new long[h + 10][w + 10];
        dp[0][0] = 1;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (field[i][j]) {
                    dp[i + 1][j] = (dp[i + 1][j] + dp[i][j]) % MOD;
                    dp[i][j + 1] = (dp[i][j + 1] + dp[i][j]) % MOD;
                }
            }
        }
        System.out.println(dp[h - 1][w - 1]);
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new DP_H().run();
    }
}
