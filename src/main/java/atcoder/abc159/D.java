package atcoder.abc159;

import java.util.*;

public class D {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] count = new int[n];
        for (int i = 0; i< n; i++) {
            int a = sc.nextInt() - 1;
            arr[i] = a;
            count[a]++;
        }

//        debug(arr);
//        debug(count);

        long total = 0;
        for (int i = 0; i < n; i++) {
            total += ((long) count[i]) * (count[i] - 1) / 2;
        }

//        debug(total);

        for (int i = 0; i< n; i++) {
            System.out.println(total - (count[arr[i]] - 1));
        }

    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
