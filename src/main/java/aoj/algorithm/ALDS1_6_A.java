package aoj.algorithm;

import java.util.Scanner;

public class ALDS1_6_A {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arrSize = n + 1;
        int[] arr = new int[arrSize];
        int max = 0;

        for (int i = 1; i < arrSize; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(arr[i], max);
        }

        int[] output = new int[arrSize];

        countingSort(arr, output, max);

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < arrSize; i++) {
                sb.append(output[i]);
                sb.append(" ");
        }
        sb.setLength(sb.length() - 1);

        System.out.println(sb);

    }

    void countingSort(int[] A, int[] B, int k) {
        int[] C = new int[k + 1];
        for (int i = 0; i < C.length; i++) {
            C[i] = 0;
        }
        for (int j = 1; j < A.length; j++) {
            C[A[j]]++;
        }
        for (int i = 1; i < C.length; i++) {
            C[i] = C[i] + C[i - 1];
        }
        for (int j = A.length - 1; j > 0; j--) {
            B[C[A[j]]] = A[j];
            C[A[j]]--;
        }
    }

    public static void main(String[] args) {
        new ALDS1_6_A().run();
    }

}