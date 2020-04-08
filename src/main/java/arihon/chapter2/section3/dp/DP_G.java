package arihon.chapter2.section3.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/dp/tasks/dp_g
 * solved: https://atcoder.jp/contests/dp/submissions/11686488
 */
public class DP_G {

    List<Integer>[] list;
    int[] dp;
    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        list = new List[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i =0 ; i< m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            list[x].add(y);
        }
        dp = new int[n];
        Arrays.fill(dp, -1);
        // dp[i] ... ノードiからスタートする場合の最大経路長
        int ans = -1;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, rec(i));
        }
        System.out.println(ans);
    }

    int rec(int i) {
        if (dp[i] != -1) {
            return dp[i];
        }
        int res = 0;
        for (int j : list[i]) {
            res = Math.max(res,rec(j) + 1);
        }

        dp[i] = res;
        return res;
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new DP_G().run();
    }
}
