package arihon.chapter2.section4;

import java.util.*;

/**
 * problem: https://atcoder.jp/contests/joi2010yo/tasks/joi2010yo_d
 * solved: https://atcoder.jp/contests/joi2010yo/submissions/10995730
 */
public class JOI2010YO_D {

    int n, k;
    int[] cards, selected;
    boolean[] used;
    Set<Integer> ans = new HashSet<>();

    void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        cards = new int[n];
        selected = new int[k];
        used = new boolean[n];
        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            used[i] = true;
            selected[0] = cards[i];
            perm(i, 1);
            used[i] = false;
        }

        System.out.println(ans.size());

    }

    void perm(int pos, int usedCount) {
        if (usedCount == k) {
            StringBuffer sb = new StringBuffer();
            for (int i : selected) {
                sb.append(i);
            }
            ans.add(Integer.parseInt(sb.toString()));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                selected[usedCount] = cards[i];
                perm(i, usedCount + 1);
                used[i] = false;
            }
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new JOI2010YO_D().run();
    }

}
