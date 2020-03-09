package arihon.chapter1;

import java.util.*;

/**
 * problem: https://atcoder.jp/contests/arc061/tasks/arc061_a
 * solved: https://atcoder.jp/contests/abc085/submissions/10666714
 */
public class JOI2008HO_C {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] ps = new int[n + 1]; // なにもしない分を追加しておく
        for (int i = 0; i < n; i++) {
            ps[i] = sc.nextInt();
        }
        ps[n] = 0;
        Arrays.sort(ps);
        int[] psums = new int[(n + 1) * (n + 1)];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                psums[i * n + j] = ps[i] + ps[j];
            }
        }
        Arrays.sort(psums);
//        debug(psums);
        int max = Integer.MIN_VALUE;
        for (int i : ps) {
            if (i > m) continue;
            for (int j : ps) {
                if (i + j > m) continue;
                int kIdx = lowerBound(psums, m - i - j);
                int k = (kIdx == 0) ? 0 : psums[kIdx - 1];
                max = Math.max(max, i + j + k);
            }
        }
        System.out.println(max);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new JOI2008HO_C().run();
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

    public int upperBound(int[] array, int value) {
        int left = -1;
        int right = array.length;
        while (right - left > 1) {
            int middle = (right + left) / 2;
            if (array[middle] > value) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return right;
    }
}
