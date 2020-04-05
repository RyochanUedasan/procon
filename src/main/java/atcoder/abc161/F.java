package atcoder.abc161;

import java.util.*;

public class F {
    void run() {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        Set<Long> set = new HashSet<>();
        Set<Long> ans = new HashSet<>();

        set.add(n);
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                set.add(i);
                set.add(n / i);
            }
        }

        for (long i : set) {
            long nn = n;
            while (nn % i == 0) {
                nn = nn / i;
            }
            if (nn == 1 || (nn - 1) % i == 0) ans.add(i);
        }


        if (n != 2) ans.add(n - 1);
        for (long i = 2; i * i <= n; i++) {
            if ((n - 1) % i == 0) {
                ans.add(i);
                ans.add((n - 1) / i);
            }
        }

        System.out.println(ans.size());

    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }
}
