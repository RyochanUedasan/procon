package arihon.chapter2.section3.part8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/abc021/tasks/abc021_d
 * solved: https://atcoder.jp/contests/abc021/submissions/12291195
 */
public class ABC021_D {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long MOD = (long) 1e9 + 7;
        Combination combi = new Combination(100000 + 100000, MOD);
        long ans = combi.nck(n - 1 + k, n - 1);

        System.out.println(ans);
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new ABC021_D().run();
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
