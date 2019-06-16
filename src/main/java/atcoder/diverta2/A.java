package atcoder.diverta2;

import java.util.Arrays;
import java.util.Scanner;

public class A {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        // write your code
        System.out.println(k==1 ?  0 : (n - k));
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }
}
