package atcoder.abc130;

import java.util.*;

public class C {
    void run() {
        Scanner sc = new Scanner(System.in);

        long w = sc.nextLong();
        long h = sc.nextLong();
        long x = sc.nextLong();
        long y = sc.nextLong();

        System.out.println(w * h / (double) 2);
        System.out.println(x == w / (double)2 && y == h / (double)2 ? 1 : 0);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
