package practice.prime;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/arc017/tasks/arc017_1
 * solved: https://atcoder.jp/contests/arc017/submissions/12276074
 */
public class ARC017_1 {

    void run() {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(isPrime(n) ? "YES" : "NO");
    }

    public boolean isPrime(long n) {
        if (n == 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new ARC017_1().run();
    }

}
