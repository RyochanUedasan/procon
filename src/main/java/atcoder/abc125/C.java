package atcoder.abc125;

import java.util.*;

public class C {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] vArr = new int[n];
        int[] cArr = new int[n];

        for (int i = 0; i < n; i++) {
            vArr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            cArr[i] = sc.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int x = vArr[i] - cArr[i];
            sum += x > 0 ? x : 0;
        }

        // write your code
        System.out.println(sum);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
