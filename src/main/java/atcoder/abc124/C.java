package atcoder.abc124;

import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] charArr = sc.next().toCharArray();
        int n = charArr.length;
        char[] baseArr1 = new char[n];
        for (int i = 0; i < n; i++) {
            baseArr1[i] = i % 2 == 0 ? '0' : '1';
        }
        char[] baseArr2 = new char[n];
        for (int i = 0; i < n; i++) {
            baseArr2[i] = i % 2 != 0 ? '0' : '1';
        }

        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < n; i++) {
            if (charArr[i] == baseArr1[i]) {
                count1++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (charArr[i] == baseArr2[i]) {
                count2++;
            }
        }

        System.out.println(Math.min(count1, count2));

    }
}
