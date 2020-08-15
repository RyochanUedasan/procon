package atcoder.abc175;

import java.io.PrintWriter;
import java.util.*;

public class C {
    void run() {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        long x = sc.nextLong();
        long k = sc.nextLong();
        long d = sc.nextLong();

        if (x == 0) {
            System.out.println(k % 2 == 0 ? 0 : d);
            return;
        }

        long maxCount = Math.abs(x / d);
        long absD = x < 0 ? -d : d;
        if (maxCount >= k) {
            debug(1);
            System.out.println(Math.abs(x - k * absD));
        } else {
            long nokori = k - maxCount;
            if (nokori % 2 == 0) {
                debug(3);
                System.out.println(Math.abs(x % d));
            } else {
                debug(4);
                System.out.println(Math.abs(x % d - absD));
            }
        }
        // out.println("Hello World");
        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
