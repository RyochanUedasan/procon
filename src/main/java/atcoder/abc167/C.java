package atcoder.abc167;

import java.io.PrintWriter;
import java.util.*;

public class C {
    void run() {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int[] price = new int[n];
        int[][] books = new int[n][m];

        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
            for (int j = 0; j < m; j++) {
                books[i][j] = sc.nextInt();
            }
        }

        int min = Integer.MAX_VALUE;
        for (int bit = 0; bit < (1 << n); bit++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if ((bit & (1 << i)) != 0) {
                    set.add(i);
                }
            }

            int[] arr = new int[m];
            int p = 0;
            for (int i : set) {
                p += price[i];
                for (int j = 0; j < m; j++) {
                    arr[j] += books[i][j];
                }
            }

            boolean isOk = true;
            for (int i = 0; i < m; i++) {
                if (arr[i] < x) {
                    isOk = false;
                    break;
                }
            }

            if (isOk) {
                min = Math.min(min, p);
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
