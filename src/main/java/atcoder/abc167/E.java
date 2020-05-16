package atcoder.abc167;

import java.io.PrintWriter;
import java.util.*;

public class E {
    void run() {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int MOD = 998244353;

        Combination combi = new Combination(n + 100, MOD);
        int[] facts = new int[n + 1];
        facts[0] = 1;
        for (int i = 0; i < n; i++) {
            facts[i + 1] = (int) (facts[i] * (long) (m - 1) % MOD);
        }
//        debug(facts);
        long ans = 0;
        for (int i = n - 1 - k; i < n; i++) {
//            debug(i, combi.nck(n - 1, i));
            ans = (ans + combi.nck(n - 1, i) * facts[i]) % MOD;
        }
        ans = (ans * m) % MOD;
        System.out.println(ans);

    }

    public class Combination {
        int n;
        long mod;
        int[] facts;

        public Combination(int n, int mod) {
            this.n = n;
            this.mod = mod;
            facts = new int[n];
            facts[0] = 1;
            for (int i = 1; i < n; i++) {
                facts[i] = (int)((long) facts[i - 1] * i % mod);
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

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}
