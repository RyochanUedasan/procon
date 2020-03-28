package arihon.chapter2.section2.part2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/abc103/tasks/abc103_d
 * solved: https://atcoder.jp/contests/abc103/submissions/11257706
 */
public class ABC103_D {

    class Point implements Comparable<Point> {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "[" + this.x + ", " + this.y + "]";
        }

        @Override
        public int compareTo(Point that) {
            if (this.y == that.y) {
                return this.x - that.x;
            }
            return this.y - that.y;
        }
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Point[] arr = new Point[m];

        for (int i = 0;  i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            arr[i] = new Point(a, b);
        }

        Arrays.sort(arr);

//        debug(arr);

        int count = 1;
        int currentEnd = arr[0].y;

        for (int i= 1 ;i < m; i++) {
            Point p = arr[i];
            if (currentEnd <= p.x) {
                currentEnd = p.y;
                count++;
            }
        }
        System.out.println(count);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new ABC103_D().run();
    }
}
