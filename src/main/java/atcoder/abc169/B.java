package atcoder.abc169;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.*;

public class B {
    void run() {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        long[] arr = new long[n];

        BigDecimal bd = new BigDecimal(1);

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            if (arr[i] == 0) {
                System.out.println(0);
                return;
            }
        }

        BigDecimal bdLimit = new BigDecimal(1e18);

        for (int i = 0; i < n; i++) {
            bd = bd.multiply(new BigDecimal(arr[i]));
            if (bd.compareTo(bdLimit) == 1) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(bd.longValue());

        // out.println("Hello World");
        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
