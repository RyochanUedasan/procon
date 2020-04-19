package arihon.chapter2.section3.part6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/maximum-cup-2018/tasks/maximum_cup_2018_d
 * solved:
 */
public class CHOKUDAI_S001_H {

    void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // dp[i] ... 長さがiの単調増加数列の中で、最終要素の最小値
        for (int i = 0; i < N; i++) {
            int a = arr[i];
            int j = lowerBound(dp, a);
//            debug(dp, a, j);
            dp[j] = a;
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                ans++;
            }
        }
//        debug(dp);
        System.out.println(ans);
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
        new CHOKUDAI_S001_H().run();
    }
}
