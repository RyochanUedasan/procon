package arihon.chapter2.section4;

import java.util.*;

/**
 * problem: https://atcoder.jp/contests/abc088/tasks/abc088_d
 * solved: https://atcoder.jp/contests/abc054/submissions/10995462
 */
public class ABC054_C {

    int n, m, ans;
    boolean[] visited;
    List<Integer>[] lists;

    void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        lists = new List[n];

        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            lists[a].add(b);
            lists[b].add(a);
        }

        ans = 0;
        visited = new boolean[n];
        visited[0] = true;
        dfs(0, 1);
        System.out.println(ans);
    }

    void dfs(int i, int visitedCount) {
        if (visitedCount == n) {
            ans++;
            return;
        }
        List<Integer> nexts = lists[i];
        for (int next : nexts) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, visitedCount + 1);
                visited[next] = false;
            }
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new ABC054_C().run();
    }

}
