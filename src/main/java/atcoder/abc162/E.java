package atcoder.abc162;

import java.util.*;

public class E {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long MOD = (long) 1e9 + 7;

        // gcd{A1, A2, ... AN} = Xとなる数列の個数は？
        long ans = 0;
        long[] count = new long[k + 1];

        for (int i = k; i >= 1; i--) {
            int x = k / i;
            long p = pow(x, n, MOD);
            for (int j = 0; j <= x; j++) {
                p = p - count[i * j] > 0 ? p - count[i * j] : p - count[i * j] + MOD;
            }
            count[i] = p;
        }
        for (int i = 0; i <= k; i++) {
            ans = (ans + count[i] * i % MOD) % MOD;
        }
//        for (int i = k; i >= 1; i--) {
//            long tmp = 1;
//            for (int j = 0; j < n; j++) {
//                tmp = tmp * (k / i) % MOD;
//            }
//            for (int j = 1; j <= k / i; j++) {
//                long x = tmp - count[i * j];
//                tmp = x > 0 ? x % MOD : x + MOD;
//            }
//            count[i] = tmp;
//            ans = (ans +  tmp * i) % MOD;
//        }

        System.out.println(ans);
    }

    int gcd(int m, int n) {
        if (m < n) return gcd(n, m);
        if (n == 0) return m;
        return gcd(n, m % n);
    }

    long pow(int i, int n, long mod) {
        if (n == 0) {
            return 1;
        }
        long tmp = pow(i, n / 2, mod);
        tmp = tmp * tmp % mod;
        if (n % 2 == 1) {
            tmp = tmp * i % mod;
        }
        return tmp;
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}
