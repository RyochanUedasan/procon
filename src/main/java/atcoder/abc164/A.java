package atcoder.abc164;

import java.util.*;

public class A {
    void run() {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int w = sc.nextInt();
        System.out.println(s <= w ? "unsafe" : "safe");
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }
}
