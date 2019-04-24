package aoj.algorithm;

import java.util.Scanner;

public class ALDS1_2_B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int count = selectionSort(arr);
        printArray(arr);
        System.out.println(count);
    }

    static int selectionSort(int[] arr) {
        int n = arr.length;
        int counter = 0;
        for (int i = 0; i < n; i++) {
            int minJ = i;
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[minJ]) {
                    minJ = j;
                }
            }
            if (minJ != i) {
                int tmp = arr[minJ];
                arr[minJ] = arr[i];
                arr[i] = tmp;
                counter++;
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
