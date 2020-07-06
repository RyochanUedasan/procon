package atcoder.abc170;

import java.io.PrintWriter;
import java.util.*;

public class D {
    void run() {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int[] arr = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        Arrays.sort(arr);


        if (arr[0] == arr[n - 1]) {
            System.out.println(0);
            return;
        }


        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            if (i < n - 1 && arr[i] == arr[i + 1]) {
                visited[i] = true;
            }

            for (int j = i + 1; j < n; j++) {
                if (visited[j]) {
                    continue;
                }

                if (arr[j] % arr[i] == 0) {
                    visited[j] = true;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) ans++;
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
