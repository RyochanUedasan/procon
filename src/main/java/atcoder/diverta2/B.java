package atcoder.diverta2;

import java.util.*;

public class B {

    class P {
        int x, y;
        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            P p = (P) o;
            return this.x == p.x && this.y == p.y;
        }

        @Override
        public int hashCode() {
            return this.x + this.y;
        }
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        P[] pArr = new P[n];

        Map<P, Integer> pMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            pArr[i] = new P(sc.nextInt(), sc.nextInt());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                P p1 = pArr[i];
                P p2 = pArr[j];
                P p = new P(p1.x - p2.x, p1.y - p2.y);
                int count = pMap.getOrDefault(p, 0) + 1;
                pMap.put(p, count);
            }
        }
        Integer[] arr = pMap.values().toArray( new Integer[0]);
        Arrays.sort(arr, Collections.reverseOrder());

        System.out.println(n == 1 ? 1 : n - arr[0]);
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
