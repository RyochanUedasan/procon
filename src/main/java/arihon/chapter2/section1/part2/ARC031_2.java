package arihon.chapter2.section1.part2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/atc001/tasks/dfs_a
 * solved: https://atcoder.jp/contests/arc031/submissions/10738737
 */
public class ARC031_2 {

    char[][] field = new char[10][10];
    boolean[][] visited;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    int count;

    void run() {
        Scanner sc = new Scanner(System.in);
        int[] start = new int[2];
        int oCount = 0;
        for (int i = 0; i < 10; i++) {
            char[] chars = sc.next().toCharArray();
            for (int j = 0; j < 10; j++) {
                field[i][j] = chars[j];
                if (chars[j] == 'o') {
                    start = new int[]{i, j};
                    oCount++;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                visited =  new boolean[10][10];
                count = 0;
                dfs(start[0], start[1], i, j);
                if (count == oCount + 1) {
                    System.out.println("YES");
                    return;
                }
            }
        }

        System.out.println("NO");
    }

    void dfs(int x, int y, int addX, int addY) {
        count++;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < 10 && 0 <= ny && ny < 10 && !visited[nx][ny] && (field[nx][ny] == 'o' || (nx == addX && ny == addY))) {
                dfs(nx, ny, addX, addY);
            }
        }
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new ARC031_2().run();
    }

}
