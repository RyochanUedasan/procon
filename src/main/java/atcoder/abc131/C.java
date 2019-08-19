package atcoder.abc131;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    void run() {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        long d = sc.nextLong();

        long countC = b / c - a / c + (a % c == 0 ? 1 : 0);
        long countD = b / d - a / d + (a % d == 0 ? 1 : 0);
        long cd = lcm(c, d);
        long countCD = b / cd - a / cd + (a % cd == 0 ? 1 : 0);
        System.out.println(b - a + 1 - countC - countD + countCD);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    long lcm (long a, long b) {
        long temp;
        long c = a;
        c *= b;
        while((temp = a%b)!=0) {
            a = b;
            b = temp;
        }
        return (long)(c/b);
    }


    public static void main(String[] args) {
        new C().run();
    }
}
