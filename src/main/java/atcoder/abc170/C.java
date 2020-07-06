package atcoder.abc170;

import java.io.PrintWriter;
import java.util.*;

public class C {
    void run() {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int x = sc.nextInt();
        int n = sc.nextInt();

        Set<Integer> set = new HashSet();

        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        int abs = 1000;
        int ans = 0;
        for (int i = 0; i <= 101; i++) {
            if (set.contains(i)) {
                continue;
            }
            int d = Math.abs(x - i);
            if (d < abs) {
                abs = d;
                ans = i;
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
        new C().run();
    }
}
