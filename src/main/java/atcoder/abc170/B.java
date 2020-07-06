package atcoder.abc170;

import java.io.PrintWriter;
import java.util.*;

public class B {
    void run() {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int m = y - 2 * x;
        int n = 4 * x - y;

        if (m % 2 == 0 && m >= 0 && n % 2 == 0 && n >= 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");

        }


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
