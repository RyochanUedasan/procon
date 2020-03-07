package atcoder.abc158;

import java.util.*;

public class E {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        String s = sc.next();

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int sub = Integer.parseInt(s.substring(i, j));
                if (sub == 0) {
                    continue;
                }
                if (sub % p == 0) count++;
            }
        }
        System.out.println(count);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}
