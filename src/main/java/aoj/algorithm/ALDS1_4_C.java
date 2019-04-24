package aoj.algorithm;

import java.util.*;

public class ALDS1_4_C {

    static int NOT_FOUND = 99999999;
    static int M = 1046527;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] intArr = new Integer[M];
        for (int i = 0; i < n; i++) {
            String command = sc.next();
            String value = sc.next();
            if (command.equals("insert")) {
                insert(intArr, toInt(value));
            } else {
                if (search(intArr, toInt(value)).equals(NOT_FOUND)) {
                    System.out.println("no");
                } else {
                    System.out.println("yes");
                }
            }

        }
    }

    static int getChar(char ch) {
        if (ch == 'A') {
            return 1;
        } else if (ch == 'C') {
            return 2;
        } else if (ch == 'G') {
            return 3;
        } else if (ch == 'T') {
            return 4;
        } else {
            return 0;
        }
    }

    static int toInt(String s) {
        int sum = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            sum += Math.pow(5, i) * getChar(arr[i]);
        }
        return sum;
    }

    static int h1(int key) {
        return key % M;
    }

    static int h2(int key) {
        return 1 + (key % (M - 1));
    }

    static int h(int key, int i) {
        return (h1(key) + i * h2(key)) % M;
    }

    static int insert(Integer[] arr, int key) {
        int i = 0;
        while (true) {
            int j = h(key, i);
            if (arr[j] == null) {
                arr[j] = key;
                return j;
            } else {
                i++;
            }
        }
    }

    static Integer search(Integer[] arr, int key) {
        int i = 0;
        while (true) {
            int j = h(key, i);
            if (arr[j] == null || i >= M) {
                return NOT_FOUND;
            } else if (key == arr[j]) {
                return j;
            } else {
                i++;
            }
        }
    }

}
