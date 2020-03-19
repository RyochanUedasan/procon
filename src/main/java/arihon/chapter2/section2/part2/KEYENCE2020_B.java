package arihon.chapter2.section2.part2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/keyence2020/tasks/keyence2020_b
 * solved: https://atcoder.jp/contests/keyence2020/submissions/10997147
 */
public class KEYENCE2020_B {

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
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int l = sc.nextInt();
            points[i] = new Point(x - l, x + l);
        }

        Arrays.sort(points);

//        debug(points);
        int count = 0;
        int currentEnd = Integer.MIN_VALUE;
        for (Point point : points) {
            if (currentEnd <= point.x) {
                currentEnd = point.y;
                count++;
            }
        }
        System.out.println(count);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new KEYENCE2020_B().run();
    }
}
