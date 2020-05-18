package atcoder.abc168;

import java.io.PrintWriter;
import java.util.*;

public class B {
    void run() {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int k = sc.nextInt();
        String s = sc.next();

        System.out.println(s.length() <= k ? s : s.substring(0, k) + "...");

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
