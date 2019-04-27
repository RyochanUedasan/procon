package atcoder.arc031;

import java.util.*;

public class B {
    char[][] field;

    void run() {
        Scanner sc = new Scanner(System.in);

        field = new char[10][10];
        for (int i = 0; i < 10; i++) {
            field[i] = sc.next().toCharArray();
        }

        int landCount = 1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                landCount += field[i][j] == 'o' ? 1 : 0;
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Set<Integer> visited = new HashSet();
                dfs(visited, 10 * i + j, true);
                if (visited.size() == landCount) {
                    System.out.println("YES");
                    System.exit(0);
                }
            }
        }
        System.out.println("NO");

    }

    void dfs(Set<Integer> visited, int cur, boolean isFirst) {
        if (isFirst) {
            visited.add(cur);
        } else if (visited.contains(cur) || field[cur / 10][cur % 10] == 'x') {
            return;
        } else {
            visited.add(cur);
        }
        if (cur % 10 != 9) dfs(visited, cur + 1, false);
        if (cur % 10 != 0) dfs(visited, cur - 1, false);
        if (cur / 10 != 0) dfs(visited, cur - 10, false);
        if (cur / 10 != 9) dfs(visited, cur + 10, false);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
