package atcoder.abc165;

import java.util.*;

public class B {
    void run() {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        int i = 1;
        long cur = 100;
        for (; i < 100000; i++) {
            cur = (long) Math.floor(cur * 1.01);
            if (cur >= x) {
                break;
            }
        }
        System.out.println(i);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
