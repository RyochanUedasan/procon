package atcoder.abc162;

import java.util.*;

public class F {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] aArr = new int[n];

        for (int i = 0; i < n; i++) {
            aArr[i] = sc.nextInt();
        }

        long[][][] dp = new long[n + 1][3][2];
        for (long[][] x : dp) {
            for (long[] x2 : x) {
                Arrays.fill(x2, Long.MIN_VALUE);
            }
        }
        dp[1][0][1] = aArr[0];
        dp[1][1][0] = 0;

        // dp[i][j][k] ... i番目までの整数列で、(ox)の順になってないやつj個、(直前の数を使っていなければk = 0)の最大値
//        debug(dp);
        for (int i = 1; i < n; i++) {
            dp[i + 1][0][1] = dp[i][0][0] + aArr[i];
            dp[i + 1][1][1] = dp[i][1][0] + aArr[i];
            dp[i + 1][2][1] = dp[i][2][0] + aArr[i];
            dp[i + 1][0][0] = dp[i][0][1];
            dp[i + 1][1][0] = Math.max(dp[i][0][0], dp[i][1][1]);
            dp[i + 1][2][0] = Math.max(dp[i][1][0], dp[i][2][1]);
        }

        List<Long> list;
        if (n % 2 == 0) {
            // o x o x o x
            // x o x o x o
            // o x x o x o
            list = Arrays.asList(dp[n][1][1], dp[n][0][0]);
        } else {
            // x o x o x o x
            // o x x x o x o
            // x x o x o x o
            list = Arrays.asList(dp[n][1][0], dp[n][2][1]);

        }
//        debug(list);
        System.out.println(Collections.max(list));
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }
}
