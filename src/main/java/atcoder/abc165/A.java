package atcoder.abc165;

import java.util.*;

public class A {
    void run() {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        boolean ans = false;
        for (int i = a; i<= b; i++) {
            if (i % k == 0) {
                ans = true;
                break;
            }
        }
        System.out.println(ans? "OK": "NG");
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }
}
