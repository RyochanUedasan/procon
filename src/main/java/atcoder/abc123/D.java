package atcoder.abc123;

import java.util.*;

public class D {

    static Long[] aArr;
    static Long[] bArr;
    static Long[] cArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int k = sc.nextInt();
        aArr = new Long[x];
        bArr = new Long[y];
        cArr = new Long[z];

        for (int i = 0; i < x; i++) {
            aArr[i] = sc.nextLong();
        }

        for (int i = 0; i < y; i++) {
            bArr[i] = sc.nextLong();
        }

        for (int i = 0; i < z; i++) {
            cArr[i] = sc.nextLong();
        }

        Arrays.sort(aArr);
        Arrays.sort(bArr);
        Arrays.sort(cArr);

        PriorityQueue<V> Q = new PriorityQueue<>();
        Q.add(new V(aArr[x - 1] + bArr[y - 1] + cArr[z - 1], x - 1, y - 1, z - 1));
        HashSet<Long> visited = new HashSet<>();
        visited.add(toId(x - 1, y - 1, z - 1));

        for (int i = 0; i < k; i++) {
            V cur = Q.remove();
            System.out.println(cur.cost);

            if (cur.a - 1 >= 0 && !visited.contains(toId(cur.a - 1, cur.b, cur.c))) {
                Q.add(new V(aArr[cur.a - 1] + bArr[cur.b] + cArr[cur.c], cur.a - 1, cur.b, cur.c));
                visited.add(toId(cur.a - 1, cur.b, cur.c));
            }

            if (cur.b - 1 >= 0 && !visited.contains(toId(cur.a, cur.b - 1, cur.c))) {
                Q.add(new V(aArr[cur.a] + bArr[cur.b - 1] + cArr[cur.c], cur.a, cur.b - 1, cur.c));
                visited.add(toId(cur.a, cur.b - 1, cur.c));
            }

            if (cur.c - 1 >= 0 && !visited.contains(toId(cur.a, cur.b, cur.c - 1))) {
                Q.add(new V(aArr[cur.a] + bArr[cur.b] + cArr[cur.c - 1], cur.a, cur.b, cur.c - 1));
                visited.add(toId(cur.a, cur.b, cur.c - 1));
            }
        }


    }

    static long toId(int a, int b, int c) {
        return (long) a * 1000 * 1000 + b * 1000 + c;
    }

    static class V implements Comparable<V> {
        long cost;
        int a, b, c;

        public V(long cost, int a, int b, int c) {
            this.cost = cost;
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(V v) {
            return v.cost - this.cost > 0 ? 1 : -1;
        }

    }

    static void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

}
