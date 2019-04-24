package aoj.algorithm;

import java.util.*;

public class ALDS1_6_C {
    class Card {
        String suit;
        int value;

        public Card(String suit, int value) {
            this.suit = suit;
            this.value = value;
        }
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Card[] arr = new Card[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Card(sc.next(), sc.nextInt());
        }

        Card[] mergeArr = arr.clone();

        mergeSort(mergeArr, 0, arr.length, 0);
        quickSort(arr, 0, arr.length - 1);

        boolean isStable = true;
        for (int i = 0; i < n; i++) {
            if (!mergeArr[i].equals(arr[i])) {
                isStable = false;
                break;
            }
        }
        System.out.println(isStable ? "Stable" : "Not stable");
        for (int i = 0; i < n; i++) {
            Card c = arr[i];
            System.out.println(c.suit + " " + c.value);

//            Card c2 = mergeArr[i];
//            System.out.println(c2.suit + " " + c2.value);
        }
    }

    public static void main(String[] args) {
        new ALDS1_6_C().run();
    }

    static void quickSort(Card[] arr, int p, int r) {
        if (p < r) {
            int q = partition(arr, p, r);
            quickSort(arr, p, q - 1);
            quickSort(arr, q + 1, r);
        }
    }

    static int partition(Card[] arr, int p, int r) {
        Card x = arr[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (arr[j].value <= x.value) {
                i = i + 1;
                Card tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        Card tmp = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = tmp;
        return i + 1;
    }

    int merge(Card[] arr, int left, int mid, int right) {
        int n1 = mid - left;
        int n2 = right - mid;
        Card[] l = new Card[n1 + 1];
        Card[] r = new Card[n2 + 1];
        for (int i = 0; i < n1; i++) {
            l[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++) {
            r[i] = arr[mid + i];
        }
        l[n1] = new Card("X", Integer.MAX_VALUE);
        r[n2] = new Card("x", Integer.MAX_VALUE);
        int i = 0;
        int j = 0;
        int count = 0;
        for (int k = left; k < right; k++) {
            count++;
            if (l[i].value <= r[j].value) {
                arr[k] = l[i];
                i = i + 1;
            } else {
                arr[k] = r[j];
                j = j + 1;
            }
        }
        return count;
    }

    int mergeSort(Card[] arr, int left, int right, int count) {
        if (left + 1 < right) {
            int mid = (left + right) / 2;
            int x = mergeSort(arr, left, mid, count);
            int x2 = mergeSort(arr, mid, right, count);
            count = count + x + x2 + merge(arr, left, mid, right);
        }
        return count;
    }
}