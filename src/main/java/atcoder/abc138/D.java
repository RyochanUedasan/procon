package atcoder.abc138;

import java.util.*;
import java.io.PrintWriter;

public class D {
    int[] ans;
    boolean[] visited;
    List<Integer>[] tree;

    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        ans = new int[n];
        tree = new List[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            tree[a].add(b);
            tree[b].add(a);
        }

        for (int i = 0; i < q; i++) {
            int p = sc.nextInt() - 1;
            int x = sc.nextInt();
            ans[p] += x;
        }

        dfs(0);

        PrintWriter pw = new PrintWriter(System.out);

        pw.print(ans[0]);
        for (int i = 1; i < n; i++) {
            pw.print(" ");
            pw.print(ans[i]);
        }
        pw.println();
        pw.flush();
    }

    void dfs(int parent) {
        visited[parent] = true;
        List<Integer> nextNodes = tree[parent];
        for (int nodeIdx : nextNodes) {
            if (!visited[nodeIdx]) {
                ans[nodeIdx] += ans[parent];
                dfs(nodeIdx);
            }
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
