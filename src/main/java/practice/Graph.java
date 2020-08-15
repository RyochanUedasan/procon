//package practice;
//
//import java.io.PrintWriter;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Scanner;
//import java.util.Set;
//
//// verify: https://atcoder.jp/contests/abc126/submissions/13251819
//public class UnionFind {
//
//    class UF {
//
//        int n;
//        int[] par; // 親の要素の番号
//        int[] rank; // 木の高さ
//
//        public UF(int n) {
//            this.n = n;
//            par = new int[n];
//            rank = new int[n];
//            for (int i = 0; i < n; i++) {
//                par[i] = i;
//                rank[i] = 0;
//            }
//
//        }
//
//        // 木の根を求める
//        int find(int x) {
//            if (par[x] == x) {
//                return x;
//            } else {
//                return par[x] = find(par[x]);
//            }
//        }
//
//        // xとyの属する集合を併合
//        void unite(int x, int y) {
//            x = find(x);
//            y = find(y);
//            if (x == y) return;
//
//            if (rank[x] < rank[y]) {
//                par[x] = y;
//            } else {
//                par[y] = x;
//                if (rank[x] == rank[y]) rank[x]++;
//            }
//        }
//
//        boolean same(int x, int y) {
//            return find(x) == find(y);
//        }
//    }
//
//    void run() {
//        Scanner sc = new Scanner(System.in);
//        PrintWriter out = new PrintWriter(System.out);
//
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//
//        UF uf = new UF(n);
//
//        int count = 0;
//        for (int i = 0; i < m; i++) {
//            int x = sc.nextInt() - 1;
//            int y = sc.nextInt() - 1;
//            int z = sc.nextInt();
//
////            if (z % 2 == 1) {
////                // xとyは別の数。
////                count++;
////            } else {
////                uf.unite(x, y);
////            }
//            uf.unite(x, y);
//        }
////        debug(uf.par);
////        debug(uf.rank);
//
//        Set<Integer> set  = new HashSet<>();
//        for (int i = 0 ; i < n; i++) {
//            set.add(uf.find(i));
//        }
//        System.out.println(set.size());
//
//        out.flush();
//    }
//
//    void debug(Object... os) {
//        System.err.println(Arrays.deepToString(os));
//    }
//
//    public static void main(String[] args) {
//        new UnionFind().run();
//    }
//}
