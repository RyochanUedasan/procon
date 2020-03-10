package arihon.chapter2.section2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/arc037/tasks/arc037_b
 * solved: https://atcoder.jp/contests/arc037/submissions/10739575
 */
public class ARC037_B {

    List<Integer>[] lists;
    boolean[] visited;
    int count = 0;
    boolean isTree = true;

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        lists = new List[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            lists[u].add(v);
            lists[v].add(u);
        }


        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                isTree = true;
               dfs(i, -1);
               count += isTree ? 1 : 0;
            }
        }
        System.out.println(count);

    }

    void dfs(int i, int before) {
        if (visited[i]) {
            isTree = false;
            return;
        }
        visited[i] = true;
        List<Integer> nexts = lists[i];
        for (int next : nexts) {
            if (next == before) continue;
            dfs(next, i);
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new ARC037_B().run();
    }

}
