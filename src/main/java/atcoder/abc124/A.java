package atcoder.abc124;

import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = 0;
        if (a > b) {
            sum = sum + a;
            a--;
        } else {
            sum = sum + b;
            b--;
        }

        if (a > b) {
            sum = sum + a;
            a--;
        } else {
            sum = sum + b;
            b--;
        }

        System.out.println(sum);
    }
}
