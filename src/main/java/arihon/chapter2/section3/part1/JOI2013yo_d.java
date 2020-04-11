package arihon.chapter2.section3.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/joi2013yo/tasks/joi2013yo_d
 * solved: https://atcoder.jp/contests/joi2013yo/submissions/11726088
 */
public class JOI2013yo_d {
    int[][] arr;

    void run() {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int n = sc.nextInt();
        int[] tArr = new int[d];
        for (int i = 0; i < d; i++) {
            tArr[i] = sc.nextInt();
        }
        arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()};
        }

        // dp[i][j] ... i日目にjの派手さを持つ服を選んだ場合の、それまでのansの最大値
        int[][] dp = new int[d + 1][110];
        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }

        for (int c : find(tArr[0])) {
            dp[1][c] = 0;
        }

        for (int i = 1; i < d; i++) {
            int t = tArr[i];
            List<Integer> list = find(t);
//            debug(list);
            for (int j = 0; j <= 100; j++) {
                if (dp[i][j] != -1) {
                    for (int c : list) {
                        dp[i + 1][c] = Math.max(dp[i + 1][c], dp[i][j] + Math.abs(c - j));
                    }
                }
            }
        }

//        debug(dp);
        int ans = 0;
        for (int i = 0; i < 110; i++) {
            ans = Math.max(ans, dp[d][i]);
        }
        System.out.println(ans);

    }

    List<Integer> find(int t) {
        List<Integer> list = new ArrayList<>();
        for (int[] a : arr) {
            if (a[0] <= t && t <= a[1]) {
                list.add(a[2]);
            }
        }
        return list;
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new JOI2013yo_d().run();
    }
}
