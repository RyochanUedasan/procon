package aoj.algorithm;

import java.util.*;

public class ALDS1_4_A {

    static int NOT_FOUND = 99999999;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] sArr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sArr[i] = sc.nextInt();
        }

        int q = sc.nextInt();
        int[] tArr = new int[q + 1];
        int count = 0;
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            tArr[i] = x;
            if (linearSearch(n, sArr, x) != NOT_FOUND) count++;
        }
        System.out.println(count);
    }

    public static int linearSearch(int n, int[] arr, int key) {
        int i = 0;
        arr[n] = key;
        while (arr[i] != key) {
            i++;
        }
        if (i == n) {
            return NOT_FOUND;
        }
        return i;
    }
}
