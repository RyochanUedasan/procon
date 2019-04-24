package aoj.algorithm;

import java.util.Scanner;

public class ALDS1_2_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int count = bubbleSort(arr);
        printArray(arr);
        System.out.println(count);
    }

    static int bubbleSort(int[] arr) {
        int counter = 0;
        int n = arr.length;
        boolean flag = true;
        for (int i = 0; flag; i++) {
            flag = false;
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                    counter++;
                    flag = true;
                }
            }
        }
        return counter;
    }


    static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length - 1; i++) {
            sb.append(arr[i]);
            sb.append(" ");
        }
        sb.append(arr[arr.length - 1]);
        System.out.println(sb.toString());
    }
}
