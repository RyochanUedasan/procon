package atcoder.abc138;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    void run() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String s = sc.next();

        System.out.println(a >= 3200 ? s : "red");
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }
}
