package atcoder.abc170;

import java.io.PrintWriter;
import java.util.*;

public class E {

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
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] rates = new int[n];
        int[] yos = new int[n];
        int M = 2 * 100000;
        PriorityQueue<Integer>[] qs = new PriorityQueue[M];
        for (int i = 0; i < M; i++) {
            qs[i] = new PriorityQueue<>((i1, i2) -> i2 - i1);
        }

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt() - 1;
            rates[i] = a;
            yos[i] = b;
            qs[b].add(a);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            Integer j = qs[i].peek();

            if (j == null) {
                continue;
            }
//            debug(j);
            if (j < min) {
                min = j;
            }
        }

        for (int i = 0; i < q; i++) {
            int c = sc.nextInt() - 1;
            int d = sc.nextInt() - 1;
            int yo = yos[c];
            yos[c] = d;
            int rate = rates[c];
            qs[yo].removeIf(p -> p == rate);
            qs[d].add(rate);
            Integer j1 = qs[yo].peek();
            Integer j2 = qs[d].peek();
            debug(qs[1233], qs[5677], qs[2019]);
            if (j1 == null) {
                for (int j = 0; j < M; j++) {
                    Integer k = qs[j].peek();

                    if (k == null) {
                        continue;
                    }
                    if (k < min) {
                        min = k;
                    }
                }
                System.out.println(min);
                continue;
            }
            if (j1 < min) {
                min = j1;
            }
            if (j2 != null && j2 < min) {
                min = j2;
            }
            System.out.println(min);

        }


        // out.println("Hello World");
        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}
