package atcoder.abc165;

import java.util.*;

public class D {
    void run() {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long n = sc.nextLong();

//        for (int i = 0; i < n; i++) {
//            long target = (long) Math.floor(a * i / b) - a * (long) Math.floor(i / b);
//            debug(i, target);
//        }
        long ans;
        if (b > n) {
            ans = (long) Math.floor(a * n / b) - a * (long) Math.floor(n / b);
        } else {
ans =                (long) Math.floor(a * (b - 1) / b) - a * (long) Math.floor((b - 1) / b);
        }
        System.out.println(ans);




//        long left = -1;
//        long right = n;
//        long max = Integer.MIN_VALUE;
//        long idx = -1;
//        while (right - left > 1) {
//            long middle = (right + left) / 2;
//            long target = (long) Math.floor(a * middle / b) - a * (long) Math.floor(middle / b);
//            if (max < target) {
//                max = target;
//                idx = middle;
//                left = middle;
//            } else {
//                right = middle;
//            }
//        }
//        System.out.println(max);

    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
