package arihon.chapter2.section3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/abc088/tasks/abc088_d
 * solved: https://atcoder.jp/contests/agc033/submissions/10754587
 */
public class AGC033_A {

    char[][] field;
    boolean[][] visited;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    Queue<Integer[]> q = new ArrayDeque<>();

    void run() {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        field = new char[h][w];
        visited = new boolean[h][w];
        int bCount = 0;

        for (int i = 0; i < h; i++) {
            char[] chars = sc.next().toCharArray();
            for (int j = 0; j < w; j++) {
                field[i][j] = chars[j];
                if (chars[j] == '#') {
                    q.add(new Integer[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        int count = -1;
        while (!q.isEmpty()) {
            Integer[] next = q.remove();
            int x = next[0];
            int y = next[1];
            int depth = next[2];
            count = Math.max(count, depth);
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < h && 0 <= ny && ny < w && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Integer[]{nx, ny, depth + 1});
                }
            }
        }

        System.out.println(count);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new AGC033_A().run();
    }

}
