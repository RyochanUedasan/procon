package arihon.chapter2.section1.part1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/arc029/tasks/arc029_1
 * solved: https://atcoder.jp/contests/arc029/submissions/10732322
 */
public class ARC029_1 {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ts = new int[n];
        for (int i = 0; i < n; i ++) {
            ts[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;

        for (int bit = 0; bit < (1 << n); bit++) {
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < n; i++) {
                if ((bit & (1 << i)) != 0) {
                    sum1+= ts[i];
                } else {
                    sum2 += ts[i];
                }
            }
            min = Math.min(min, Math.max(sum1, sum2));
        }

        System.out.println(min);
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new ARC029_1().run();
    }

}
