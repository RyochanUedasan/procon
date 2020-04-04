package arihon.chapter2.section2.part4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/abc083/tasks/arc088_a
 * solved: https://atcoder.jp/contests/abc091/submissions/11578544
 */
public class ARC092_A {

    class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + this.x + ", " + this.y + ")";
        }

    }

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] aArr = new Point[n];
        Point[] bArr = new Point[n];
        for (int i = 0; i < n; i ++) {
            aArr[i] = new Point(sc.nextInt(), sc.nextInt());
        }
        for (int i = 0; i < n; i ++) {
            bArr[i] = new Point(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(aArr, (o1, o2) -> o1.x - o2.x);
        Arrays.sort(bArr, (o1, o2) -> o1.x - o2.x);
        int count = 0;
        for (Point b : bArr) {
            Arrays.sort(aArr, (o1, o2) -> o2.y - o1.y);
            for (int i = 0; i < n; i++) {
                Point a = aArr[i];
                if (a.x == Integer.MAX_VALUE) {
                    continue;
                }
                if (a.x < b.x && a.y < b.y) {
                    count++;
                    aArr[i] = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
                    break;
                }
            }
        }
        System.out.println(count);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new ARC092_A().run();
    }
}
