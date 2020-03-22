package atcoder.agc043;

import java.util.*;

/**
3 3
.##
.##
###
=> 1

4 4
.###
####
####
###.
 => 1
 *
 *
 */
public class A {
    int h, w;
    char[][] field;
    int[][] visited;
    int ans = Integer.MAX_VALUE;
    int[] dx = {1, 0};
    int[] dy = {0, 1};


    void run() {
        Scanner sc = new Scanner(System.in);
        h = sc.nextInt();
        w = sc.nextInt();
        field = new char[h][w];
        visited = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                visited[i][j] = 1000000;
            }
        }

        for (int i = 0; i < h; i++) {
            field[i] = sc.next().toCharArray();
        }
        dfs(0, 0, field[0][0] == '.' ? 0 : 1, field[0][0]);
        System.out.println(ans);
    }

    void dfs(int x, int y, int count, char c) {
        if (x == h - 1 && y == w - 1) {
            ans = Math.min(count, ans);
            return;
        }
        visited[x][y] = count;
            for (int i = 0; i < 2; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < h && 0 <= ny && ny < w) {
                    char nc = field[nx][ny];
                    int nCount = count + (nc == c || nc == '.' ? 0 : 1);
                    if (nCount < visited[nx][ny]) {
                        dfs(nx, ny, nCount, nc);
                    }
                }
            }
    }

    void search(int x, int y) {

    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }
}
