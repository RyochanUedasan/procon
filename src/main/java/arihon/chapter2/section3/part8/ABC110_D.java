package arihon.chapter2.section3.part8;

import java.util.*;

/**
 * problem: https://atcoder.jp/contests/abc110/tasks/abc110_d
 * solved: https://atcoder.jp/contests/abc110/submissions/12277739
 */
public class ABC110_D {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long MOD = (long) 1e9 + 7;
        Map<Long, Long> map = primeFactorization(m);
        Combination combi = new Combination(n + 10000, MOD);
        long count = 1;
        for (long v : map.values()) {
            count = count * combi.nck(n + (int) v - 1, (int) v) % MOD;
        }

        System.out.println(count % MOD);

    }

    Map<Long, Long> primeFactorization(long n) {
        Map<Long, Long> map = new HashMap<>();
        for (long i = 2; i * i <= n; i++) {
            if (n % i != 0) continue;
            long count = 0;
            while (n % i == 0) {
                count++;
                n = n / i;
            }
            map.put(i, count);
        }
        if (n != 1) map.put(n, 1L);
        return map;
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new ABC110_D().run();
    }

    public class Combination {
        int n;
        long mod;
        long[] facts;

        public Combination(int n, long mod) {
            this.n = n;
            this.mod = mod;
            facts = new long[n];
            facts[0] = 1;
            for (int i = 1; i < n; i++) {
                facts[i] = facts[i - 1] * i % mod;
            }
        }

        long modpow(long a, long b) {
            if (b == 0) return 1;
            else if (b == 1) return a;

            long x = modpow(a, b / 2);
            return b % 2 == 0 ? x * x % mod : x * (x * a % mod) % mod;
        }

        long inv(long n) {
            return modpow(n, mod - 2);
        }

        public long nck(int n, int k) {
            if (n < k) return 0;
            return facts[n] * (inv(facts[n - k]) * inv(facts[k]) % mod) % mod;
        }
    }

}
