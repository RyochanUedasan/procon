package atcoder.abc126;

import java.util.*;

public class D {
    class P {
        int i;
        long w;

        public P(int i, long w) {
            this.i = i;
            this.w = w;
        }
    }
    boolean[] visited;
    boolean[] blacks;
    List<P>[] listArr;

    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        listArr = new ArrayList[n + 1];

        visited = new boolean[n + 1];
        blacks = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            listArr[i] = new ArrayList<P>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long w = sc.nextLong();

            listArr[u].add(new P(v, w));
            listArr[v].add(new P(u, w));
        }

        dfs(1, true);

        for (int i = 1; i < n + 1; i++) {
            System.out.println(blacks[i] ?  "1" : "0");
        }
    }

    void dfs(int i, boolean isBlack) {
        if (visited[i]) return;
        visited[i] = true;
        if (isBlack) blacks[i] = true;
        List<P> pList = listArr[i];
        for (P p : pList) {
            boolean hoge = (blacks[i] && p.w % 2 == 0) || (!blacks[i] && p.w % 2 != 0);
            dfs(p.i, hoge);
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
