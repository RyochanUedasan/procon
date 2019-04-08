package atcoder.abc123;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];
        int min = 10;
        int minIdx = 0;
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
            if (min > arr[i] % 10 && arr[i] % 10 != 0) {
                min = arr[i] % 10;
                minIdx = i;
            }
        }
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            if (i == minIdx) {
                sum += arr[i];
            } else {
                sum += Math.ceil(arr[i] / 10.0) * 10;
            }
        }
        System.out.println(sum);
    }
}
