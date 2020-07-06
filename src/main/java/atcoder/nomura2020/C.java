package atcoder.nomura2020;

import java.io.PrintWriter;
import java.util.*;

public class C {
    void run() {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        long[] dp = new long[n + 1];
        dp[n] = arr[n];

        for (int i = n; i >= 0; i--) {
            dp[i - 1] = dp[i] - arr[i] + arr[i - 1];
        }

        // out.println("Hello World");
        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
