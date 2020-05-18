package atcoder.abc168;

import java.io.PrintWriter;
import java.util.*;

public class E {
    void run() {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        long[][] is = new long[n][2];
        Map<Double, Integer> set = new HashMap<>();
        long MOD = (long) 1e9 + 7;
        boolean[] ng = new boolean[n];
        for (int i = 0; i < n; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            double d = (double) a / b;
            double revD = (double) -b / a;
            int count = set.getOrDefault(d, 0) + 1;
            set.put(d, count);
        }


        debug(ng);

        long ans = 0;
        int ngs = 0;
        for (int i = 0; i < n; i++) {
            if (ng[i]) {
                ngs++;

            } else {
                ans = ans * 2 % MOD;
            }
        }


        // out.println("Hello World");
        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}
