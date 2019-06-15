package atcoder.abc128;

import java.util.*;

public class D {
    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        ArrayDeque<Integer> ad = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            ad.offer(sc.nextInt());
        }


    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
