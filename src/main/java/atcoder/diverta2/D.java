package atcoder.diverta2;

import java.util.Arrays;
import java.util.Scanner;

public class D {

    void run() {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long root = (long) Math.ceil(Math.sqrt(n));

        long sum = 0;

        for (int x = 1; x < root; x++) {
            if (n % x == 0) {
                long m = n / x - 1;
                if (x < m) sum += m;
            }
        }
        // write your code
        System.out.println(sum);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
