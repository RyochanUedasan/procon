package atcoder.agc044;

import java.io.PrintWriter;
import java.util.*;

public class A {
    class Pair {

        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + this.x + ", " + this.y + ")";
        }
    }

    long n;

    void run() {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            n = sc.nextLong();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
//            Pair p2 = new Pair(2, a);
//            Pair p3 = new Pair(3, b);
//            Pair p5 = new Pair(5, c);
//            Pair p1 = new Pair(1, d);
//
//            List<Pair[]> list = new ArrayList<>();
//            list.add(new Pair[]{});
//            list.add(new Pair[]{p2});
//            list.add(new Pair[]{p3});
//            list.add(new Pair[]{p5});
//            list.add(new Pair[]{p2, p3});
//            list.add(new Pair[]{p2, p5});
//            list.add(new Pair[]{p3, p5});
//            list.add(new Pair[]{p2, p3, p5});

            int[] dp = new int[(int) n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int j = 0; j < n; j++) {
                if (j * 2 <= n) {
                    dp[j * 2] = Math.min(dp[j * 2], dp[j] + a);
                }

                if (j * 3 <= n) {
                    dp[j * 3] = Math.min(dp[j * 3], dp[j] + b);
                }

                if (j * 5 <= n) {
                    dp[j * 5] = Math.min(dp[j * 5], dp[j] + c);
                }
                dp[j + 1] = Math.min(dp[j + 1], dp[j] + d);
            }
            System.out.println(dp[(int) n]);
        }

        // out.println("Hello World");
        out.flush();
    }

    long solve(Pair p1, Pair[] arr) {
        long x = 1;
        long res = Long.MAX_VALUE;
        long cost = p1.y;
        for (Pair p : arr) {
            while (x * p.x < n) {
                x = x * p.x;
                cost += p.y;
            }
        }
        res = Math.min(res, cost + (n - x) * p1.y);

        for (Pair p : arr) {
            res = Math.min(res, cost + (x * p.x - n) * p1.y);
        }
        debug(arr, res);

        return res;
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }
}
