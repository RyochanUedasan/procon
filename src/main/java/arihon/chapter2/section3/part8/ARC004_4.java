package arihon.chapter2.section3.part8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/arc004/tasks/arc004_4
 * solved: https://atcoder.jp/contests/arc004/submissions/12291858
 */
public class ARC004_4 {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long MOD = (long) 1e9 + 7;
        boolean isNegative = n < 0;
        Map<Long, Long> map = primeFactorization(Math.abs(n));
        Combination combi = new Combination(100000 + 100000, MOD);
        long ans = 1;
        for (long v : map.values()) {
            ans = ans * combi.nck((int) v + m - 1, m - 1) % MOD;
        }

        long count = 0;
        for (int i = isNegative ? 1 : 0; i <= m; i = i + 2) {
            count = (count + combi.nck(m, i)) % MOD;
        }

        System.out.println(ans * count % MOD);
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
        new ARC004_4().run();
    }

}
