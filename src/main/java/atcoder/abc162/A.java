package atcoder.abc162;

import java.util.*;

public class A {
    void run() {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        boolean ans = false;
        for (char c : n.toCharArray()) {
            if (c == '7') {
                ans = true;
            }
        }
        System.out.println(ans ? "Yes" : "No");
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }
}
