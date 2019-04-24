package aoj.algorithm;

import java.util.*;

public class ALDS1_5_A {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int q = sc.nextInt();
        int[] mArr = new int[q];
        for (int i = 0; i < mArr.length; i++) {
            mArr[i] = sc.nextInt();
        }

        for (int m : mArr) {
            System.out.println(solve(arr, 0, m) ? "yes" : "no");
        }

    }

    // i番目以降の配列を使って、mを作る
    static boolean solve(int[] arr, int i, int m) {
        if (m == 0) {
            return true;
        } else if (i >= arr.length) {
            return false;
        }
        return solve(arr, i + 1, m) || solve(arr, i + 1, m - arr[i]);
    }

}