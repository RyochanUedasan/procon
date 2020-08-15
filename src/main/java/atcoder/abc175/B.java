package atcoder.abc175;

import java.io.PrintWriter;
import java.util.*;

public class B {
    void run() {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i< n;i ++) {
            arr[i] = sc.nextLong();
        }

        int count = 0;
        for (int i =0 ; i< n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    long a1 = arr[i];
                    long a2 = arr[j];
                    long a3 = arr[k];
                    if (a1 != a2 && a2 != a3 && a3 != a1) {
                        if (a1 + a2 > a3 && a2 + a3 > a1 && a3 + a1 > a2) {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
        // out.println("Hello World");
        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
