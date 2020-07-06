package atcoder.abc169;

import java.io.PrintWriter;
import java.util.*;

public class F {
    void run() {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        long MOD = 998244353;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long[] dp = new long[s + 1]; // dp[i] ... iになるようなf(T)の数
        dp[0] = 1;
        long[] dp2;

        for (int i = 0; i < n; i++) {
//            debug(dp);
            dp2 = new long[s + 1];
            int a = arr[i];
            for (int j = 0; j <= s; j++) {
                if (j - a >= 0) {
                    dp2[j] = dp[j] * 2 + dp[j - a];
                } else {
                    dp2[j] = dp[j] * 2;
                }
            }
            for (int j = 0; j <= s; j++) {
                dp[j] = dp2[j] % MOD;
            }
        }

        System.out.println(dp[s]);


        // out.println("Hello World");
        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }
}
