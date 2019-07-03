package atcoder.abc132;

import java.util.*;

public class F {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        long MOD = (long) 1e9 + 7;

        List<Integer> units = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            units.add(i);
        }

        List<Integer> unitsRev = new ArrayList<>();
        for (int i = 1; i * i < n; i++) {
            if (i != n / i) unitsRev.add(n / i);
        }
        Collections.reverse(unitsRev);
        units.addAll(unitsRev);

        int size = units.size();
        counts.add(1);
        for (int i = 1; i < size; i++) {
            counts.add(units.get(i) - units.get(i - 1));
        }

        long[][] dp = new long[k][size];

        for (int j = 0; j < size; j++) {
            dp[0][j] = 0;
        }

        for (int j = 0; j < size; j++) {
            dp[1][j] = counts.get(j) * (n / units.get(j)) % MOD;
        }

        for (int i = 2; i < k; i++) {
            dp[i][size - 1] = counts.get(size - 1) * dp[i - 1][0] % MOD;
            long[] sums = new long[size];
            sums[0] = dp[i - 1][0];
            for (int l = 1; l < size; l++) {
                sums[l] = (sums[l - 1] + dp[i - 1][l]) % MOD;
            }
            for (int j = size - 2; j >= 0; j--) {
                dp[i][j] = counts.get(j) * sums[size - j - 1] % MOD;
            }
        }

        long ans = 0;
        for (int j = 0; j < size; j++) {
            ans = (ans + dp[k - 1][j]) % MOD;
        }
        System.out.println(ans);

    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }
}
