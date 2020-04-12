package arihon.chapter2.section3.part3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * problem: http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=2502
 * solved: http://judge.u-aizu.ac.jp/onlinejudge/review.jsp?rid=4347853#1
 */
public class AOJ2502 {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()};
        }

        int N = 393;
        // dp[i] ... iの長さのメロディの最高得点
        int[] dp = new int[N + 1];
        Arrays.fill(dp, 0);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < n; j++) {
                int s = arr[j][0];
                int l = arr[j][1];
                int p = arr[j][2];
                for (int k = s; k <= Math.min(i + 1, l); k++) {
//                    debug(i, j, k, dp);
                    dp[i + 1] = Math.max(dp[i], Math.max(dp[i + 1], dp[i + 1 - k] + p));
                }
            }
        }
//        debug(dp);
        int m = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            if (dp[x] == 0) {
                System.out.println(-1);
                return;
            }
            list.add(dp[x]);
        }

        for(int x : list) {
            System.out.println(x);
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new AOJ2502().run();
    }
}
