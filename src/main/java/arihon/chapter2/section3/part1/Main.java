package arihon.chapter2.section3.part1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    void run() {
        String S = "12345";
        int L = S.length();

        // dp[i][j] ... i桁目まで決めたときの総数。過去に対応する数より小さい値を入れたことがない => j = 0
        int[][] dp = new int[L + 1][2];
        dp[0][0] = 1;

        for (int i = 0; i < L; i++) {
            int D = Character.getNumericValue(S.charAt(i));
            for (int j = 0; j < 2; j++) {
                for (int d = 0; d <= (j == 0 ? D : 9); d++) {
                    dp[i + 1][j == 0 && d == D ? 0 : 1] += dp[i][j];
                }
            }
        }
        System.out.println(dp[L][0] + dp[L][1]);
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
