package arihon.chapter2.section1;

import java.util.*;

/**
 * problem: https://atcoder.jp/contests/abc079/tasks/abc079_c
 * solved: https://atcoder.jp/contests/abc079/submissions/10701109
 */
public class ABC079_C {
    void run() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int ops = s.length() - 1;
        int ans = 0;
        for (int bit = 0; bit < (1 << ops); bit++) {
            int sum = Character.getNumericValue(s.charAt(0));
            for (int i = 0; i < ops; i++) {
                int next = Character.getNumericValue(s.charAt(i + 1));
                if ((bit & (1 << i)) != 0) sum += next;
                else sum -= next;
            }
            if (sum == 7) {
                ans = bit;
                break;
            }
        }
        System.out.print(s.charAt(0));
        for (int i = 0; i < ops; i++) {
            System.out.print((ans & (1 << i)) != 0 ? "+" : "-");
            System.out.print(s.charAt(i + 1));
        }
        System.out.println("=7");
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new ABC079_C().run();
    }

}
