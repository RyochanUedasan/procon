package atcoder.tenkaichi2019;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int k = sc.nextInt();

        char target = s.charAt(k - 1);

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == target) {
                System.out.print(target);
            } else {
                System.out.print("*");
            }
        }

    }
}
