package atcoder.panasonic2020;

import java.util.*;

public class C {
    void run() {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

        String ans = (c - a - b) * (c - a - b) - 4 * a * b > 0
                ? "Yes" : "No";
        if (c - a - b < 0) ans = "No";

        System.out.println(ans);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
