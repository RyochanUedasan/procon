package atcoder.abc123;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long[] arr = new long[5];
        long min = Long.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextLong();
            min = Math.min(arr[i], min);
        }

        long ans = n % min == 0 ? n / min - 1 + 5 : n / min + 5;

        System.out.println(ans);
    }
}
