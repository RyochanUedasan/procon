package arihon.chapter2.section3.part9;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ARC085_B {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int z = sc.nextInt();
        int w = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = Integer.MIN_VALUE;
        }
        dp[1][1] = Math.abs(arr[0] - w);
        for (int i = 1; i < n; i++) {
            for (int k = 0; k <= n - i; k++) {
                int y = i == 1 ? w : arr[i - 1];
                dp[i + k][1] = Math.max(dp[i + k][1], Math.abs(arr[i + k - 1] - y));
                int x = i == 1 ? z : arr[i - 1];
                dp[i + k][0] = Math.min(dp[i + k][0], Math.abs(arr[i - 1 + k] - x));
            }
            debug(dp);
        }
//        debug(dp);
        System.out.println(Math.max(dp[n][0], dp[n][1]));
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new ARC085_B().run();
    }
}

