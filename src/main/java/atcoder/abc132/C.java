package atcoder.abc132;

import java.util.Arrays;
import java.util.Scanner;

public class C {

    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dArr = new int[n];

        for (int i = 0; i < n; i++) {
            dArr[i] = sc.nextInt();
        }

        Arrays.sort(dArr);

        int lower = dArr[n / 2 - 1];
        int upper = dArr[n / 2];

        System.out.println(upper - lower);


        // write your code
//        System.out.println("Hello World");
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
