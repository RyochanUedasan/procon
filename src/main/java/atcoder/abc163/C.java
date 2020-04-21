package atcoder.abc163;

import java.util.*;

public class C {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0 ; i< n - 1; i++) {
            arr[sc.nextInt() - 1]++;
        }

        for (int i = 0; i < n;i++) {
            System.out.println(arr[i]);
        }


    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
