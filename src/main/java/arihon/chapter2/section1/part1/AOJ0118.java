package arihon.chapter2.section1.part1;

import java.util.*;

/**
 * problem: http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0118#
 * TODO: 通らない。なぜだかわからない。。
 */
public class AOJ0118 {

    int h, w;
    char[][] field;

    void run() {
        Scanner sc = new Scanner(System.in);
        h = sc.nextInt();
        w = sc.nextInt();

        field = new char[h][w];
        for (int i = 0; i < h; i++) {
            String s = sc.next();
            for (int j = 0; j < w; j++) {
                field[i][j] = s.charAt(j);
            }
        }

        // すてる
        sc.next();
        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (field[i][j] != 'X') {
                    dfs(i, j, field[i][j]);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    void dfs(int x, int y, char c) {
        field[x][y] = 'X';
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < h && 0 <= ny && ny < w && c == field[nx][ny]) {
                dfs(nx, ny, c);
            }
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new AOJ0118().run();
    }

}
