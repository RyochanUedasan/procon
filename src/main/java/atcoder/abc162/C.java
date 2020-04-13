package atcoder.abc162;

import java.util.*;

public class C {
    void run() {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        long ans = 0;
        for (int i = 1; i <= K - 2; i++) {
            for (int j = i + 1; j <= K - 1; j++) {
                for (int k = j + 1; k <= K; k++) {
                    ans += 6 * gcd(gcd(i, j), k);
                }
            }
        }
//        debug(ans);

        for (int i = 1; i <= K - 1; i++) {
            for (int j = i + 1; j <= K; j++) {
                ans += 6 * gcd(i, j);
            }
        }

//        debug(ans);


        for (int i = 1; i <= K; i++) {
            ans += i;
        }

        System.out.println(ans);
    }

    int gcd(int m, int n) {
        if (m < n) return gcd(n, m);
        if (n == 0) return m;
        return gcd(n, m % n);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
