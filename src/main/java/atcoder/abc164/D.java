package atcoder.abc164;

import java.util.*;

public class D {
    void run() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();

        // dp[i][j] ... i文字目までで、あまりがjのやつの個数

        int[] dp = new int[2019];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int[] dp2 = new int[2019];

            int next = Character.getNumericValue(s.charAt(i));
            dp2[next] = 1;
            for (int j = 0; j < 2019; j++) {
                dp2[(10 * j + next) % 2019] += dp[j];
            }
            for (int j = 0; j < 2019; j++) {
                dp[j] = dp2[j];
            }
            ans += dp2[0];
        }
        System.out.println(ans);
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
