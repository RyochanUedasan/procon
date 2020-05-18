package arihon.chapter2.section4;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FoodChain {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = 100;
        int k = 7;
        int[][] arrs = new int[][]{
                {1, 101, 1},
                {2, 1, 2},
                {2, 2, 3},
                {2, 3, 3},
                {1, 1, 3},
                {2, 3, 1},
                {1, 5, 5}
        };
        // i-xは「iが種類xである場合」を表す。
        // x, x + N, x + 2 * N をx-A, x-B, x-Cの要素とする。
        UF uf = new UF(n * 3);

        int ans = 0;
        for (int[] arr : arrs) {
            int t = arr[0];
            int x = arr[1] - 1;
            int y = arr[2] - 1;
            if (x < 0 || n <= x || y < 0 || n <= y) {
                ans++;
                continue;
            }

            if (t == 1) {
                // xとyは同じ
                if (uf.same(x, y + n) || uf.same(x, y + 2 * n)) {
                    ans++;

                } else {
                    uf.unite(x, y);
                    uf.unite(x + n, y + n);
                    uf.unite(x + 2 * n, y + 2 * n);
                }
            } else {
                // xはyを食べる
                if (uf.same(x, y) || uf.same(x, y + 2 * n)) {
                    ans++;
                } else {
                    uf.unite(x, y + n);
                    uf.unite(x + n, y + 2 * n);
                    uf.unite(x + 2 * n, y);
                }
            }
        }
        System.out.println(ans);

    }

    class UF {

        int n;
        int[] par; // 親の要素の番号
        int[] rank; // 木の高さ

        public UF(int n) {
            this.n = n;
            par = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                par[i] = i;
                rank[i] = 0;
            }

        }

        // 木の根を求める
        int find(int x) {
            if (par[x] == x) {
                return x;
            } else {
                return par[x] = find(par[x]);
            }
        }

        // xとyの属する集合を併合
        void unite(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) return;

            if (rank[x] < rank[y]) {
                par[x] = y;
            } else {
                par[y] = x;
                if (rank[x] == rank[y]) rank[x]++;
            }
        }

        boolean same(int x, int y) {
            return find(x) == find(y);
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new FoodChain().run();
    }
}
