package practice;

import java.util.*;

public class Prime {
    void run() {
        debug(isPrime(113));
        debug(listDivisors(12));
        debug(primeFactorization(2020));
    }


    // verify: https://atcoder.jp/contests/arc017/submissions/12276074
    boolean isPrime(long n) {
        if (n == 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    //
    List<Long> listDivisors(long n) {
        List<Long> list = new ArrayList<>();
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                if (n / i != i) {
                    list.add(n / i);
                }
            }
        }
        return list;
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

    public static void main(String... args) {
        new Prime().run();
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }




}
