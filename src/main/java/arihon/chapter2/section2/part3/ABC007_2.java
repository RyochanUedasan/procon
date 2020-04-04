package arihon.chapter2.section2.part3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/abc007/tasks/abc007_2
 * solved: https://atcoder.jp/contests/abc007/submissions/11419256
 */
public class ABC007_2 {

    void run() {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        System.out.println(a.equals("a") ? "-1" : "a");
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new ABC007_2().run();
    }
}
