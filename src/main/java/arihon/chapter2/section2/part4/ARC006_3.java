package arihon.chapter2.section2.part4;

import java.util.*;

/**
 * problem: https://atcoder.jp/contests/arc006/tasks/arc006_3
 * solved: https://atcoder.jp/contests/arc006/submissions/11475487
 */
public class ARC006_3 {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] now = new int[n];
        Arrays.fill(now, Integer.MAX_VALUE);

        for (int w : arr) {
//            debug(now);
            for (int i = 0; i < n; i++) {
                if (w <= now[i]) {
                    now[i] = w;
                    break;
                }
            }
            Arrays.sort(now);
        }

        int count = 0;
        for (int m : now) {
            if (m < Integer.MAX_VALUE) count++;
        }

        System.out.println(count);

    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new ARC006_3().run();
    }
}
