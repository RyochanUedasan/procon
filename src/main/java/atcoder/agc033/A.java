package atcoder.agc033;

import java.util.*;

public class A {
    int h;
    int w;
    char[][] map;
    boolean[][] visited;

    void run() {
        Scanner sc = new Scanner(System.in);

        h = sc.nextInt();
        w = sc.nextInt();

        map = new char[h][w];
        visited = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            map[i] = sc.next().toCharArray();
        }

        List<Integer> blacks = new ArrayList<>();

        // 1000 * 1000
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == '#') {
                    visited[i][j] = true;
                    blacks.add(toPoint(i, j));
                }
            }
        }

        int count = -1;
        while (true) {
            if (blacks.isEmpty()) break;
            count++;
            blacks = next(blacks);
        }

        // write your code
        System.out.println(count);
    }

    List<Integer> next(List<Integer> blacks) {
        List<Integer> newBlacks = new ArrayList<>();

        for (int bp : blacks) {
            int i = bp / 1000;
            int j = bp % 1000;

            if (bp % 1000 != 0 && !visited[i][j - 1]) {
                visited[i][j - 1] = true;
                newBlacks.add(bp - 1);
            }
            if (bp % 1000 != w - 1 && !visited[i][j + 1]) {
                visited[i][j + 1] = true;
                newBlacks.add(bp + 1);
            }
            if (bp / 1000 != 0 && !visited[i - 1][j]) {
                visited[i - 1][j] = true;
                newBlacks.add(bp - 1000);
            }
            if (bp / 1000 != h - 1 && !visited[i + 1][j]) {
                visited[i + 1][j] = true;
                newBlacks.add(bp + 1000);
            }
        }
        return newBlacks;
    }


    int toPoint(int i, int j) {
        return i * 1000 + j;
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }
}
