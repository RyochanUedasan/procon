package atcoder.abc159;

import java.util.*;

public class E {
    int h, w, k;
    boolean[][] grid;
    int count;
    void run() {
        Scanner sc = new Scanner(System.in);
        h = sc.nextInt();
        w = sc.nextInt();
        k = sc.nextInt();
        grid = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            char[] arr = sc.next().toCharArray();
            for (int j = 0; j < w; j++) {
                if (arr[j] == '1') {
                    grid[i][j] = true;
                }
            }
        }

        for (int i = 0; i < (1 << h); i++) {
            
        }

    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}
