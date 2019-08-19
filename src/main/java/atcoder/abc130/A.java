package atcoder.abc130;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    void run() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int a = sc.nextInt();

        System.out.println(x < a ? 0 : 10);

    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }
}
