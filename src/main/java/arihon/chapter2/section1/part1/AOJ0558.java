package arihon.chapter2.section1.part1;

import java.util.*;

/**
 * problem: http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0118#
 * solved: https://onlinejudge.u-aizu.ac.jp/solutions/problem/0558/review/4244526/ryochanuedasan/JAVA
 */
public class AOJ0558 {
    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return this.x + ", " + this.y;
        }

    }

    int h, w, n;
    char[][] field;
    Point start;
    int goal;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};


    void run() {
        Scanner sc = new Scanner(System.in);
        h = sc.nextInt();
        w = sc.nextInt();
        n = sc.nextInt();
        field = new char[h][w];

        for (int i = 0; i < h; i++) {
            char[] chars = sc.next().toCharArray();
            for (int j = 0; j < w; j++) {
                field[i][j] = chars[j];
                if (chars[j] == 'S') {
                    start = new Point(i, j);
                }
            }
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            boolean[][] visited = new boolean[h][w];
            goal = i;
            List<Point> l = new ArrayList<>();
            l.add(start);
            visited[start.x][start.y] = true;
            int step = 0;
            while (!l.isEmpty()) {
                List<Point> next = new ArrayList<>();
                for (Point p : l) {
                    if (Character.getNumericValue(field[p.x][p.y]) == goal) {
                        count += step;
                        start = new Point(p.x, p.y);
                        next.clear();
                        break;
                    }
                    for (int j = 0; j < 4; j++) {
                        int nx = p.x + dx[j];
                        int ny = p.y + dy[j];
                        if (0 <= nx && nx < h && 0 <= ny && ny < w && !visited[nx][ny] && field[nx][ny] != 'X') {
                            next.add(new Point(nx, ny));
                            visited[nx][ny] = true;
                        }
                    }
                }
                step++;
                l = next;
            }
        }
        System.out.println(count);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new AOJ0558().run();
    }
}
