package atcoder.agc035;

import java.util.*;

public class A {

    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Set<Integer> set = new HashSet<>();

        int current = 0;
        for (int i = 0; i < n;i++) {
            current = current ^ sc.nextInt();
        }

        System.out.println(current == 0 ? "Yes": "No");
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }
}
