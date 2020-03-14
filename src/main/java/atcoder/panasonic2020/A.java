package atcoder.panasonic2020;

import java.util.*;

public class A {
    void run() {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[] arr = new int[]{1, 1, 1, 2, 1, 2, 1, 5, 2, 2, 1, 5, 1, 2, 1, 14, 1, 5, 1, 5, 2, 2, 1, 15, 2, 2, 5, 4, 1, 4, 1, 51};

        System.out.println(arr[k- 1]);

    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }
}
