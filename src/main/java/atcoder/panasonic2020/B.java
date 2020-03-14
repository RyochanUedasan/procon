package atcoder.panasonic2020;

import java.util.*;

public class B {
    void run() {
        Scanner sc = new Scanner(System.in);
        long h = sc.nextLong();
        long w = sc.nextLong();
        long ans = (h * w + 1) / 2;
        if (h == 1 || w == 1) {
            ans = 1;
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
