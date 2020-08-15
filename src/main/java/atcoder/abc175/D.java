package atcoder.abc175;

import java.io.PrintWriter;
import java.util.*;

public class D {
    void run() {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] parr = new int[n];
        int[] carr = new int[n];
        for (int i = 0; i < n; i++) {
            parr[i] = sc.nextInt() - 1;
        }

        for (int i = 0; i < n; i++) {
            carr[i] = sc.nextInt();
        }

        boolean visited[] = new boolean[n];

        long ans = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            List<Integer> list = new ArrayList<>();
            int current = i;
            while (!visited[current]) {
                list.add(carr[current]);
                visited[current] = true;
                current = parr[current];
            }
            int l = list.size();
            long[] accList = new long[l];
            accList[0] = list.get(0);
            for (int j = 1; j < l; j++) {
                accList[j] = list.get(j) + accList[j - 1];
            }
            debug(list);
            debug(accList);
            long max = 0 ;
            for (int j = 0; j < l; j++) {
                for (int j2 = j; j2 <= j + k % l; j2++) {
                    debug(j,j2, max);

                    if (j2 <=  l - 1) {
                        max = Math.max(accList[j2] - accList[j], max);
                    } else {
                        max =Math.max(accList[l - 1] - accList[j] + accList[j2 - l], max);
                    }
                }
            }
            for (int j = 0; j < l; j++) {
                if (accList[l - 1] < 0) {
                    ans = Math.max(ans, max);
                } else {
                    ans = Math.max(ans, k / l * accList[l - 1] + max );
                }
            }
            debug("--------");
        }
        System.out.println(ans);

        // out.println("Hello World");
        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
