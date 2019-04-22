package atcoder.tenkaichi2019;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    static int n;
    static String s;
    static int[] whiteToBlack;
    static int[] blackToWhite;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.next();

        whiteToBlack = new int[n + 2];
        for (int i = n; i > 0; i--) {
            whiteToBlack[i] = (s.charAt(i - 1) == '.' ? 1 : 0) + whiteToBlack[i + 1];
        }
        whiteToBlack[0] = whiteToBlack[1];

        blackToWhite = new int[n + 2];
        for (int i = 1; i < n + 1; i++) {
            blackToWhite[i] = (s.charAt(i - 1) == '#' ? 1 : 0) + blackToWhite[i - 1];
        }
        blackToWhite[n + 1] = blackToWhite[n];

//        debug(whiteToBlack);
//        debug(blackToWhite);


        int min = n;
        for (int i = 1; i < n + 2; i++) {
            // i以上は黒にする
            min = Math.min(whiteToBlack[i] + blackToWhite[i - 1], min);
        }

        System.out.println(min);
    }

    static void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }


}
