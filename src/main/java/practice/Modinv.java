package practice;

import java.util.Arrays;
import java.util.Scanner;

public class Modinv {
    void run() {
        Scanner sc = new Scanner(System.in);
        long MOD = (long) 1e9 + 7;
        long[] facts;
        int w = sc.nextInt();
        int h = sc.nextInt();
        facts = createFacts(200004, MOD);

        System.out.println(nck(w + h - 2, w - 1, facts, MOD));

    }

    long[] createFacts(int n, long mod) {
        long[] facts = new long[n];
        facts[0] = 1;
        facts[1] = 1;

        for (int i = 2; i < n; i++) {
            facts[i] = facts[i - 1] * i % mod;
        }
        return facts;
    }

    long modPow(int n, int a, long mod) {
        if (a == 0) {
            return 1;
        } else if (a == 1) {
            return n;
        }
        long x = modPow(n, a / 2, mod);
        if (a % 2 == 0) {
            return x * x % mod;
        } else {
            return x * (x * n % mod) % mod;
        }
    }

    long modinv(long n, long mod) {
        return modPow((int) n, (int) mod - 2, mod);
    }

    long nck(int n, int k, long[] facts, long mod) {
        if (n < k) {
            return 0;
        }
        if (n < 0 || k < 0) {
            return 0;
        }
        return facts[n] * ((modinv(facts[k], mod) * modinv(facts[n - k], mod)) % mod) % mod;
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new Modinv().run();
    }

}
