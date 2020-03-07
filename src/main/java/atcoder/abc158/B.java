package atcoder.abc158;

import java.util.*;

public class B {
    void run() {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long a = sc.nextLong();
        long b = sc.nextLong();
        long div = n / (a + b);
        long mod = n % (a + b);
        System.out.println(div * a + Math.min(mod, a));
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
