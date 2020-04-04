package arihon.chapter2.section2.part4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/abc005/tasks/abc005_3
 * solved: https://atcoder.jp/contests/abc005/submissions/11565353
 */
public class ABC005_3 {

    void run() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();
        int[] aArr = new int[n];
        for (int i = 0; i < n; i++) {
            aArr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] bArr = new int[m];
        for (int i = 0; i < m; i++) {
            bArr[i] = sc.nextInt();
        }


        int currentIdx = 0;
        boolean ans = true;
        for (int i = 0; i < m; i++) {
            int b = bArr[i];
            boolean isOk = false;
            while (currentIdx < n) {
                if (aArr[currentIdx] <= b && b <= aArr[currentIdx] + t) {
                    currentIdx++;
                    isOk = true;
                    break;
                }
                currentIdx++;
            }
            if (!isOk) {
                ans = false;
                break;
            }
        }

        System.out.println(ans ? "yes" : "no");


    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new ABC005_3().run();
    }
}
