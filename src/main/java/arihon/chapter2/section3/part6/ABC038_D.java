package arihon.chapter2.section3.part6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/abc038/tasks/abc038_d
 * solved: https://atcoder.jp/contests/abc038/submissions/12069607
 */
public class ABC038_D {

    void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i] = new int[] {sc.nextInt(), sc.nextInt()};
        }

        Arrays.sort(arr, (a1, a2) -> {
           if (a1[1] - a2[1] == 0) {
               return - a1[0] + a2[0];
           }
           return a1[1] - a2[1];
        });
//        debug(arr);

        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            int j = lowerBound(dp, arr[i][0]);
            dp[j] = arr[i][0];
        }
//        debug(dp);

        int ans = 0;
        for (int i = 0; i< N; i++) {
            if (dp[i] != Integer.MAX_VALUE) ans++;
        }
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
        new ABC038_D().run();
    }
}
