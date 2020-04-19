package arihon.chapter2.section3.part6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem:
 * solved:
 */
public class Main {

    void run() {
        Scanner sc = new Scanner(System.in);
        int N = 5;
        int[] a = {4, 2, 3, 1, 5};

        int[] dp = new int[N + 1];
        // dp[i] ... 最後がa[i]であるような部分列の中で最長のものの長さ
        dp[0] = 1; // 最後がa[0]であるような部分文字列の中で最長 => 自分自身 => 1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (a[i] > a[i - j]) {
                    dp[i] = Math.max(dp[i], dp[i - j] + 1);
                } else {
                    dp[i] = Math.max(dp[i], 1);
                }
            }
        }
        int ans = -1;
        for (int i = 0; i  < N; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
