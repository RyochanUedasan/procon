package atcoder.abc130;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class D {
    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long k = sc.nextLong();

        long[] accArr = new long[n + 1];
        accArr[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            accArr[i] = accArr[i - 1] + sc.nextLong();
        }


        long count = 0;
        int right = 1;
        for (int i = 1; i < n + 1; i++) {
            while (true) {
                if (accArr[right] - accArr[i - 1] < k) {
                    if (right == n) {
                        break;
                    }
                    right++;
                } else {
                    count = count + n - right + 1;
                    break;
                }
            }
        }

        System.out.println(count);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
