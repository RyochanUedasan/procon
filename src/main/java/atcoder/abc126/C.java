package atcoder.abc126;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        double sum = 0;
        int indexMax = 0;
        int j = 1;
        while (j < k) {
            j = j * 2;
            indexMax++;
        }

        for (int i = 1; i <= n; i++) {
            if (i >= k) {
                sum += Math.pow(2, indexMax);
                continue;
            }

            int index = 0;
            int i2 = i;
            while (i2 < k) {
                index++;
                i2 = i2 * 2;
            }

            sum += Math.pow(2, indexMax - index);
        }


        System.out.println(sum / (n * Math.pow(2, indexMax)));
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
