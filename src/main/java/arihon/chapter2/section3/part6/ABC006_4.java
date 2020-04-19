package arihon.chapter2.section3.part6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/abc006/tasks/abc006_4
 * solved: https://atcoder.jp/contests/abc006/submissions/11995525
 */
public class ABC006_4 {

    void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            int index = lowerBound(dp, arr[i]);
            dp[index] = arr[i];
        }
//        debug(dp);

        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                ans++;
            }
        }

        System.out.println(N - ans);
    }

    public int lowerBound(int[] array, int value) {
        int left = -1;
        int right = array.length;
        while (right - left > 1) {
            int middle = (right + left) / 2;
            if (array[middle] >= value) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return right;
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new ABC006_4().run();
    }
}
