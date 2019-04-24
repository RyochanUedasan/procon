package aoj.algorithm;

import java.util.Scanner;

public class ALDS1_4_B {

    static int NOT_FOUND = 99999999;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] sArr = new int[n];
        for (int i = 0; i < n; i++) {
            sArr[i] = sc.nextInt();
        }

        int q = sc.nextInt();
        int[] tArr = new int[q];
        int count = 0;
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            tArr[i] = x;
            if (binarySearch(sArr, x) != NOT_FOUND) count++;
        }
        System.out.println(count);
    }

    public static int binarySearch(int[] arr, int key) {
        int n = arr.length;
        int left = 0;
        int right = n;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (key < arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return NOT_FOUND;
    }
}
