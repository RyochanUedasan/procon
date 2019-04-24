package aoj.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ALDS1_2_D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        List<Integer> g = new ArrayList<>();
        for (int h = 1;;) {
            if (h > arr.length) break;
            g.add(h);
            h = 3 * h + 1;
        }
        Collections.reverse(g);

        int count = shellSort(arr, g);
        System.out.println(g.size());
        printList(g);
        System.out.println(count);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    static int shellSort(int[] arr, List<Integer> g) {
        int counter = 0;
        for (int i : g) {
            counter += insertionSort(arr, i);
        }
        return counter;
    }

    static int insertionSort(int[] arr, int g) {
        int counter = 0;
        int n = arr.length;
        for (int i = g; i < n; i++) {
            int v = arr[i];
            int j = i - g;
            while (j >= 0 && arr[j] > v) {
                arr[j + g] = arr[j];
                j = j - g;
                counter++;
            }
            arr[j + g] = v;
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

    static void printList(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i));
            sb.append(" ");
        }
        sb.append(list.get(list.size() - 1));
        System.out.println(sb.toString());
    }
}
