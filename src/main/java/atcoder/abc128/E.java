package atcoder.abc128;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class E {

    int[] parents;

    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        parents = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            sc.nextInt();
            unite(x, y);
        }

        // ここまで10の6〜7じょうくらい

        Set<Integer> set = new HashSet();
        for (int i = 1; i < n + 1; i++) {
            set.add(findRep(parents[i]));
        }

        System.out.println(set.size());

    }

    void unite(int x, int y) {
        int rep1 = findRep(x);
        int rep2 = findRep(y);
        parents[rep2] = rep1;
    }

    int findRep(int x) {
        if (parents[x] != x) {
            parents[x] = findRep(parents[x]);
        }
        return parents[x];
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}
