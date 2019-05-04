package atcoder.abc125;

import java.util.*;

public class B {
    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] aArr = new long[n];

        for (int i = 0; i < n; i++) {
            aArr[i] = sc.nextLong();
        }

        long absMin = Integer.MAX_VALUE;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            absMin = Math.min(absMin, Math.abs(aArr[i]));
            sum += Math.abs(aArr[i]);
        }

        System.out.println(condition(aArr, n) ? sum : sum - 2 * absMin);
    }

    boolean condition(long[] aArr, int n) {
        // 全部+にできればtrue
        int plusCount = 0;
        for (int i = 0; i < n; i++) {
            if (aArr[i] > 0) plusCount++;
        }
        return (n % 2 == 0 && plusCount % 2 == 0) || (n % 2 != 0 && plusCount % 2 != 0);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
