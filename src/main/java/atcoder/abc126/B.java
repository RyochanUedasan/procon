package atcoder.abc126;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    void run() {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int pre = Integer.valueOf(s.substring(0, 2));
        int post = Integer.valueOf(s.substring(2, 4));

        String ans;
        boolean b1 = 0 < pre && pre <= 12;
        boolean b2 = 0 < post && post <= 12;

        if (b1 && b2) {
            ans = "AMBIGUOUS";
        } else if (b1 && !b2) {
            ans = "MMYY";
        } else if (b2 && !b1) {
            ans = "YYMM";
        } else {
            ans = "NA";
        }

        System.out.println(ans);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
