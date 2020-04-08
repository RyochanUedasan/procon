package arihon.chapter2.section3.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/dp/tasks/dp_f
 * solved: https://atcoder.jp/contests/dp/submissions/11686488
 */
public class DP_F {

    void run() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();

        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        String ans = "";
        int i = s.length();
        int j = t.length();
        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else if (dp[i][j] == dp[i][j - 1]) {
                j--;
            } else {
                ans = s.charAt(i - 1) + ans;
                i--;
                j--;
            }
        }
        System.out.println(ans);
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new DP_F().run();
    }
}
