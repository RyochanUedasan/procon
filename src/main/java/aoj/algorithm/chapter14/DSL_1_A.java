package aoj.algorithm.chapter14;

import java.util.*;

public class DSL_1_A {

    int[] parents;

    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < q; i++) {
            int comm = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (comm == 0) {
                unite(x, y);
            } else if (comm == 1){
                System.out.println(same(x, y) ? "1" : "0");
            }
        }

    }

    void unite(int x, int y) {
        int rep1 = findSet(x);
        int rep2 = findSet(y);
        parents[rep2] = rep1;
    }

    int findSet(int x) {
        int current = x;
        while (parents[current] != current) {
            current = parents[current];
        }
        return current;
    }

    boolean same(int x, int y) {
        return findSet(x) == findSet(y);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new DSL_1_A().run();
    }
}
