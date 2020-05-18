package atcoder.abc168;

import java.io.PrintWriter;
import java.util.*;

public class D {

    class Pair {
        int c, p;

        public Pair(int c, int p) {
            this.c = c;
            this.p = p;
        }

        @Override
        public String toString() {
            return this.c + ", " + this.p;
        }
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer>[] list = new List[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            list[a].add(b);
            list[b].add(a);
        }

        int[] visited = new int[n];
        Arrays.fill(visited, -1);

        Deque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, 0));

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int c = p.c;
            if (visited[c] != -1) {
                continue;
            }

            int parent = p.p;
            visited[c] = parent;
            List<Integer> nexts = list[c];
            for (int j : nexts) {
                if (visited[j] != -1) {
                    continue;
                }
//                debug(j, c, parent);
                q.add(new Pair(j, c));
            }
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == -1) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
        for (int i = 1; i < n; i++) {
            System.out.println(visited[i] + 1);
        }


        // out.println("Hello World");
        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
