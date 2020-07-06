package atcoder.abc170;

import java.io.PrintWriter;
import java.util.*;

public class A {
    void run() {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int ans = 0;
        for (int i = 0; i < 5; i++) {
            int j = sc.nextInt();
            if (j == 0) {
                ans = i + 1;
            }
        }
        System.out.println(ans);

        // out.println("Hello World");
        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }
}
