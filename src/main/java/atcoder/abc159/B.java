package atcoder.abc159;

import java.util.*;

public class B {
    void run() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                System.out.println("No");
                return;
            }
        }

        String s2 = s.substring(0, n / 2);
//        debug(s2);
        int n2 = s2.length();
        for (int i = 0; i < n2; i++) {
            if (s2.charAt(i) != s2.charAt(n2 - i - 1)) {
                System.out.println("No");
                return;
            }
        }

        String s3 = s.substring(n / 2 + 1, n);
//        debug(s3);
        int n3 = s3.length();
        for (int i = 0; i < n3; i++) {
            if (s3.charAt(i) != s3.charAt(n3 - i - 1)) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
