package atcoder.abc169;

import java.io.PrintWriter;
import java.util.*;

public class D {
    void run() {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        long n = sc.nextLong();

        Map<Long, Long> map = primeFactorization(n);

//        debug(map);

        int ans = 0;
        for (Map.Entry<Long, Long> e : map.entrySet()) {
            long m = e.getValue();
            int max = -1;
            for (int i = 1; i <= m; i++) {
                long m2 = m;
                int count = 0;
                for (int j = i; j <= m; j++) {
//                    debug(i, j, m2, count);
                    if (m2 - j >= 0) {
                        m2 = m2 - j;
                        count++;
                    }
                }
                max = Math.max(count, max);
            }
            ans = ans + max;
        }

        System.out.println(ans);

        // out.println("Hello World");
        out.flush();
    }

    Map<Long, Long> primeFactorization(long n) {
        Map<Long, Long> map = new HashMap<>();
        for (long i = 2; i * i <= n; i++) {
            if (n % i != 0) continue;
            long count = 0;
            while (n % i == 0) {
                count++;
                n = n / i;
            }
            map.put(i, count);
        }
        if (n != 1) map.put(n, 1L);
        return map;
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
