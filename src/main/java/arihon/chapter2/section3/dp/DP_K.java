package arihon.chapter2.section3.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/dp/tasks/dp_k
 * solved: https://atcoder.jp/contests/dp/submissions/11701393
 */
public class DP_K {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean[] dp = new boolean[k * 2 + 1];
        for (int i = 0 ; i < k; i++) {
            for (int j = 0 ; j < n; j ++) {
                dp[i + arr[j]] = dp[i + arr[j]] || !dp[i];
            }
        }
//        debug(dp);
        System.out.println(dp[k] ? "First" : "Second");
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new DP_K().run();
    }
}
