package atcoder.abc125;

import java.util.*;

public class D {
    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Set<Integer> set = new HashSet();

        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        Integer[] aArr = set.toArray(new Integer[0]);

        Arrays.sort(aArr);

        int m = aArr.length;

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            // aArr[i]以外のgcdを求める -> gcdTmp
            Integer gcdTmp = m == 1 ? aArr[0] : null;
            for (int j = 0; j < m; j++) {
                if (j == i) continue;

                if (gcdTmp == null) {
                    gcdTmp = aArr[j];
                } else {
                    gcdTmp = gcd(aArr[j], gcdTmp);
                }

                if (gcdTmp <= ans) break;
            }
            ans = Math.max(ans, gcdTmp);
        }

        // write your code
        System.out.println(ans);
    }

    int gcd(int m, int n) {
        if(m < n) return gcd(n, m);
        if(n == 0) return m;
        return gcd(n, m % n);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
