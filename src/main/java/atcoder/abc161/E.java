package atcoder.abc161;

import java.util.*;

public class E {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int c = sc.nextInt();
        boolean[] arr = new boolean[n];
        char[] s = sc.next().toCharArray();
        for (int i = 0; i < n; i++) {
            arr[i] = s[i] == 'o';
        }

        int count = 0;
        for (int i = 0; i <n; ) {
            if (arr[i]) {
                count++;
                i = i + c;
            }else {
                i++;
            }
        }

        if (count > k + 1) {
            return;
        }

        for (int i = 0; i < n; i++) {
            boolean isOk = true;
            boolean origin = arr[i];
            arr[i] = false;
            arr[i] = origin;
            if (!isOk) System.out.println(i + 1);
        }

    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}
