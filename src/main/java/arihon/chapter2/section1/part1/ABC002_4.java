package arihon.chapter2.section1.part1;

import java.util.*;

/**
 * problem: https://atcoder.jp/contests/abc002/tasks/abc002_4
 * solved: https://atcoder.jp/contests/abc002/submissions/10732350
 */
public class ABC002_4 {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer>[] relations = new List[n];
        for (int i = 0; i < n; i++) {
            relations[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            relations[x].add(y);
            relations[y].add(x);
        }

        int max = 0;
        for (int bit = 0; bit < (1 << n); bit++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if ((bit & (1 << i)) != 0) {
                    set.add(i);
                }
            }

            boolean isOk = true;
            for (int i : set) {
                for (int j : set) {
                    if (i != j) {
                        if (!relations[i].contains(j)) {
                            isOk = false;
                        }
                    }
                }
            }
            max = Math.max(max, isOk ? set.size() : 0);
        }
        System.out.println(max);
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new ABC002_4().run();
    }

}
