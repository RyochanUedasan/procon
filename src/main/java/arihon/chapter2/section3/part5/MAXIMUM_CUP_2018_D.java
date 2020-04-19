package arihon.chapter2.section3.part5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/maximum-cup-2018/tasks/maximum_cup_2018_d
 * solved: https://atcoder.jp/contests/maximum-cup-2018/submissions/me
 */
public class MAXIMUM_CUP_2018_D {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // dp[i][j] ... i番目までの燃料タンクを使って、jに止まった場合の最低の周回数
        int[][] dp = new int[n + 1][m];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int d = (j + arr[i]) / m;
                int mod = (j + arr[i]) % m;
                dp[i + 1][j] = dp[i][j];
                if (dp[i][mod] != Integer.MAX_VALUE) {
                    dp[i + 1][j] = Math.min(dp[i][j], dp[i][mod] + d);
                }
            }
        }
//        debug(dp);

        System.out.println(dp[n][l] < x ? "Yes" : "No");

    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new MAXIMUM_CUP_2018_D().run();
    }
}
