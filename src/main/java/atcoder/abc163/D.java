package atcoder.abc163;

import java.util.*;

public class D {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n + 1];
        long MOD = (long) 1e9 + 7;
        for (int i = 0; i < n + 1; i++) {
            nums[i] = i;
        }

        long count = 0;
        for (int i = k; i <= n + 1; i++) {
            // i個選んだ
            long min = (long) (i - 1) * i / 2;
            long max = (long) n * (n + 1) / 2 - (long) (n - i) * (n + 1 - i) / 2;
            count += (max - min + 1) % MOD;
        }
        System.out.println(count % MOD);

    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
