package atcoder.abc136;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean isPossible = true;
        int cur = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (cur >= arr[i]) {
                cur = arr[i];
            } else if  (cur + 1 < arr[i]) {
                isPossible = false;
                break;
            } else {
                // do nothing
            }
        }
        System.out.println(isPossible ? "Yes" : "No");
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
