package arihon.chapter2.section2;

import java.util.*;

/**
 * problem: http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=DPL_1_A&lang=jp
 * solved: http://judge.u-aizu.ac.jp/onlinejudge/review.jsp?rid=4274424#1
 */
public class Main {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coins = new int[m];

        for (int i = 0; i < m; i++) {
            coins[i] = sc.nextInt();
        }
        // dp[i]をi円支払う時の最小枚数とする.
        int[] dp = new int[60030];
        Arrays.fill(dp, Integer.MAX_VALUE);

        int current = 0;
        dp[0] = 0;
        for (int i = 0; i < 50000; i++) {
            for (int coin: coins) {
                int next = i + coin;
                dp[next] = Math.min(dp[next], dp[i] + 1);
            }
        }

        System.out.println(dp[n]);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
