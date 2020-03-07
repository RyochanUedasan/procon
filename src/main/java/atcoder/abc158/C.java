package atcoder.abc158;

import java.util.*;

public class C {
    void run() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int aMin = (int) Math.ceil(100 * a / (double) 8);
        int aMax = (int) Math.floor(100 * (a + 1) / (double) 8);
        int bMin = (int) Math.ceil(100 * b / (double) 10);
        int bMax = (int) Math.floor(100 * (b + 1) / (double) 10);
        int ans = -1;
        debug(aMin, aMax, bMin, bMax);
        for (int i = aMin; i < aMax; i++) {
            for (int j = bMin; j < bMax; j++) {
                if (i == j) {
                    ans = i;
                    break;
                }
            }
            if (ans != -1) {
                break;
            }
        }
        System.out.println(ans);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
