package arihon.chapter2.section2.part4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/abc083/tasks/arc088_a
 * solved: https://atcoder.jp/contests/abc083/submissions/11474650
 */
public class ARC088_A {

    void run() {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long y = sc.nextLong();
        int count = 0;
        while (x <= y) {
            count++;
            x = x * 2;
        }
        System.out.println(count);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new ARC088_A().run();
    }
}
