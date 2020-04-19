package arihon.chapter2.section3.part6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/tdpc/tasks/tdpc_target
 * solved: https://atcoder.jp/contests/tdpc/submissions/12068404
 */
public class TDPC_TARGET {

    void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i] = new int[]{sc.nextInt(), sc.nextInt()};
        }

        Arrays.sort(arr, (a1, a2) -> {
            int r = (a2[0] + a2[1]) - (a1[0] + a1[1]);
            if (r == 0) {
                int l = (a2[0] - a2[1]) - (a1[0] - a1[1]);
                return l;
            }
            return r;
        });
//        debug(arr);

        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < N; i++) {
            int j = arr[i][0] - arr[i][1];
            int k = lowerBound(dp, j);
            dp[k] = j;
        }

//        debug(dp);

        int ans = 0;
        for (int i = 0; i < N; i++) {
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
        new TDPC_TARGET().run();
    }
}
