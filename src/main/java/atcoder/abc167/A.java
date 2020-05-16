package atcoder.abc167;

import java.io.PrintWriter;
import java.util.*;

public class A {
    void run() {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String s = sc.next();
        String t = sc.next();
        out.println(s.equals(t.substring(0, t.length() - 1))? "Yes" : "No");
        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }
}
