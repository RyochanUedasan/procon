package arihon.chapter2.section1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/abc104/tasks/abc104_c
 * solved: TODO: 解けてない
 */
public class ABC104_C {
    void run() {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int g = sc.nextInt();
        int[] ps = new int[d];
        int[] cs = new int[d];
        int pCount = 0;
        for (int i = 0; i < d; i++) {
            ps[i] = sc.nextInt();
            cs[i] = sc.nextInt();
            pCount += ps[i];
        }

    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new ABC104_C().run();
    }

}
