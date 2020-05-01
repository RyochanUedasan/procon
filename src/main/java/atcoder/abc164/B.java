package atcoder.abc164;

import java.util.*;

public class B {
    void run() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        boolean win = false;
        while (a >= 0 && c >= 0) {
            c = c - b;
            if (c <= 0) {
                win = true;
                break;
            }
            a = a - d;
            if (a <= 0) {
                break;
            }
        }

        System.out.println(win ? "Yes" : "No");


    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
