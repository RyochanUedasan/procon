package atcoder.abc131;

import java.util.Arrays;
import java.util.Scanner;

public class B {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = l + i;
        }

        int tabeta = Integer.MAX_VALUE;
        int sum = 0;
        for (int a : arr) {
            if (Math.abs(tabeta) > Math.abs(a)) tabeta = a;
            sum += a;
        }
        System.out.println(sum - tabeta);

    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
