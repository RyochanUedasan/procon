package atcoder.abc169;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.*;
import java.math.RoundingMode;


public class C {
    void run() {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        BigDecimal a = sc.nextBigDecimal();
        BigDecimal b = sc.nextBigDecimal();

        System.out.println(b.multiply(a).setScale(0, RoundingMode.DOWN).longValue());

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
