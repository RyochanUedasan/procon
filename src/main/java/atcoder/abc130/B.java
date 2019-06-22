package atcoder.abc130;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class B {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] lArr = new int[n];
        for (int i = 0; i< n; i++) {
            lArr[i] = sc.nextInt();
        }

        int current = 0;
        int count = 1;
        for (int l : lArr) {
            current = current + l;
            if (current > x) break;
            count++;
        }
        System.out.println(count);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
