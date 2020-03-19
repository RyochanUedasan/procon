package arihon.chapter2.section1.part2;

import java.util.*;

/**
 * problem: https://atcoder.jp/contests/atc001/tasks/dfs_a
 * solved: https://atcoder.jp/contests/atc001/submissions/10738105
 */
public class ATC001_DFS_A {

    int h, w;
    char[][] field;
    boolean[][] visited;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    boolean isOk = false;

    void run() {
        Scanner sc = new Scanner(System.in);
        h = sc.nextInt();
        w = sc.nextInt();
        field = new char[h][w];
        visited = new boolean[h][w];
        int[] start = {0, 0};
        for (int i = 0; i < h; i++) {
            char[] chars = sc.next().toCharArray();
            for (int j = 0; j < chars.length; j++) {
                field[i][j] = chars[j];
                if (chars[j] == 's') start = new int[]{i, j};
            }
        }

        dfs(start[0], start[1]);

        System.out.println(isOk ? "Yes" : "No");
    }

    void dfs(int x, int y) {
        visited[x][y] = true;
        if (field[x][y] == 'g') isOk = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < h && 0 <= ny && ny < w && !visited[nx][ny] && field[nx][ny] != '#') {
                dfs(nx, ny);
            }
        }
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new ATC001_DFS_A().run();
    }

}
