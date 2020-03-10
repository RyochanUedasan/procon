package arihon.chapter2.section3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/abc007/tasks/abc007_3
 * solved: https://atcoder.jp/contests/abc007/submissions/10740837
 */
public class ABC007_3 {

    char[][] field;
    boolean[][] visited;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    Queue<Integer[]> q = new ArrayDeque<>();
    int count = 0;

    void run() {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int sy = sc.nextInt() - 1;
        int sx = sc.nextInt() - 1;
        int gy = sc.nextInt() - 1;
        int gx = sc.nextInt() - 1;
        field = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            char[] chars = sc.next().toCharArray();
            for (int j = 0; j < c; j++) {
                field[i][j] = chars[j];
            }
        }
        q.add(new Integer[]{sy, sx, 0});
        visited[sy][sx] = true;

        int ans = 0;
        while (!q.isEmpty()) {
            Integer[] next = q.remove();
//            debug(next);
            int count = next[2];
            if (next[0] == gy && next[1] == gx) {
                ans = count;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int ny = next[0] + dy[i];
                int nx = next[1] + dx[i];
                if (0 <= nx && nx < c && 0 <= ny && ny < r && !visited[ny][nx] && field[ny][nx] != '#') {
                    visited[ny][nx] = true;
                    q.add(new Integer[]{ny, nx, count + 1});
                }
            }
        }
        System.out.println(ans);

    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new ABC007_3().run();
    }

}
