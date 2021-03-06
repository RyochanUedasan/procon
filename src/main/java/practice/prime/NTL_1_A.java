package practice.prime;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * problem: http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=NTL_1_A&lang=ja
 * solved: http://judge.u-aizu.ac.jp/onlinejudge/review.jsp?rid=4395505#2
 */
public class NTL_1_A {

    void run() {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        Map<Long, Long> map = primeFactorization(n);
        System.out.print(n + ":");
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(e -> {
            for (int i = 0; i < e.getValue(); i++) {
                System.out.print(" " + e.getKey());
            }
        });
        System.out.println();
    }

    Map<Long, Long> primeFactorization(long n) {
        Map<Long, Long> map = new HashMap<>();
        for (long i = 2; i * i <= n; i++) {
            if (n % i != 0) continue;
            long count = 0;
            while (n % i == 0) {
                count++;
                n = n / i;
            }
            map.put(i, count);
        }
        if (n != 1) map.put(n, 1L);
        return map;
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new NTL_1_A().run();
    }

}
