package aoj.algorithm;

import java.util.Scanner;

public class ALDS1_4_D {

    static int UNAVAILABLE = -1;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] ws = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            ws[i] = sc.nextInt();
            sum += ws[i];
        }

        int right = sum;
        int left = 0;
        while (right - left > 1) {
            int center = (right + left) / 2;
            int wsn = check(ws, k, center);
            if (wsn >= n) {
                right = center;
            } else {
                left = center;
            }
        }

        System.out.println(right);
    }

    static int check(int[] ws, int k, int p) {
        int i = 0;
        for (int j = 0; j < k; j++) {
            int sum = 0;
            while (sum + ws[i] <= p) {
                sum += ws[i];
                i++;
                if (i == ws.length) return ws.length;
            }
        }
        return i;
//        int sum = 0;
//        for (int i = 0; i < ws.length; i++) {
//
//            if (ws[i] > p) {
//                return UNAVAILABLE;
//            }
//            if (k == 0) {
//                return i + 1;
//            }
//            sum += ws[i];
//            if (i == ws.length - 1) {
//                k--;
//                continue;
//            }
//            if (sum + ws[i + 1] > p) {
//                k--;
//                sum = 0;
//            }
//        }
//        return ws.length;
    }


}
