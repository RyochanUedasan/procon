package aoj.algorithm;

import java.util.Scanner;


public class ALDS1_6_B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int index = partition(arr, 0, n - 1);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n - 1; i++) {
            if (i == index) {
                sb.append("[" + arr[i] + "]");
            } else {
                sb.append(arr[i]);
            }
            sb.append(" ");
        }
        sb.append(arr[n - 1]);
        System.out.println(sb);
    }

    static int partition(int[] arr, int p, int r) {
        int x = arr[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (arr[j] <= x) {
                i = i + 1;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        int tmp = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = tmp;
        return i + 1;
    }
}