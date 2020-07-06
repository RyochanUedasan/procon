package atcoder.abc169;

import java.io.PrintWriter;
import java.util.*;

public class A {
    void run() {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int a = sc.nextInt();
        int b = sc.nextInt();

        out.println(a * b);
        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }
}
