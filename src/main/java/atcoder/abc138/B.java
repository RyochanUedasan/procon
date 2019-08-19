package atcoder.abc138;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];


        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (double) 1 / sc.nextInt();
        }

        // write your code
        System.out.println((double) 1 / sum);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
