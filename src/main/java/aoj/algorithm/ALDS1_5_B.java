package aoj.algorithm;

import java.util.Scanner;


public class ALDS1_5_B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int count = mergeSort(arr,  0, n, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            sb.append(arr[i]);
            sb.append(" ");
        }
        sb.append(arr[n - 1]);

        System.out.println(sb);
        System.out.println(count);


    }

    static int merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left;
        int n2 = right - mid;
        int[] l = new int[n1 + 1];
        int[] r = new int[n2 + 1];
        for (int i = 0; i < n1; i++) {
            l[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++) {
            r[i] = arr[mid + i];
        }
        l[n1] = Integer.MAX_VALUE;
        r[n2] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int count = 0;
        for (int k = left; k < right; k++) {
            count++;
            if (l[i] <= r[j]) {
                arr[k] = l[i];
                i = i + 1;
            } else {
                arr[k] = r[j];
                j = j + 1;
            }
        }
        return count;
    }

    static int mergeSort(int[] arr, int left, int right, int count) {
        if (left + 1 < right) {
            int mid = (left + right) / 2;
            int x = mergeSort(arr, left, mid, count);
            int x2 = mergeSort(arr, mid, right, count);
            count = count + x + x2 + merge(arr, left, mid, right);
        }
        return count;
    }
}