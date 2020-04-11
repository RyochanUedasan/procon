package arihon.chapter2.section3.part1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/tdpc/tasks/tdpc_number
 * solved: https://atcoder.jp/contests/tdpc/submissions/11734596
 */
public class TDPC_NUMBER {

    void run() {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        String n = sc.next();
        long MOD = (long) 1e9 + 7;
        int N = n.length();

        // dp[i][j][k] ... Nのi桁目までの数以下の正整数で、各桁の数の和をDで割ったあまりがjで、(過去にnに対応する数より小さい値を入れたことがない => k == 0) の総数
        long[][][] dp = new long[N + 1][d][2];
        dp[0][0][0] = 1;
        for (int i = 0; i < N; i++) {
            int D = Character.getNumericValue(n.charAt(i));
            for (int j = 0; j < d; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l <= (k == 0 ? D : 9) ; l++) {
                        dp[i + 1][(j + l) % d][k == 0 && l == D ? 0 : 1] += dp[i][j][k] % MOD;
                    }
                }
            }
        }
//        debug(dp);
        System.out.println((dp[N][0][0] + dp[N][0][1] - 1) % MOD);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new TDPC_NUMBER().run();
    }
}
