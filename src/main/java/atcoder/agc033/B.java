package atcoder.agc033;

import java.util.*;

public class B {
    int h, w, n;
    int sh, sw;
    char[] sArr, tArr;

    void run() {
        Scanner sc = new Scanner(System.in);

        h = sc.nextInt();
        w = sc.nextInt();
        n = sc.nextInt();

        sh = sc.nextInt();
        sw = sc.nextInt();

        sArr = sc.next().toCharArray();
        tArr = sc.next().toCharArray();

        boolean isOchiru = rOchiru() || lOchiru() || dOchiru() || uOchiru();


        System.out.println(isOchiru ? "NO" : "YES");
    }

    boolean rOchiru() {
        int w1 = sw;
        for (int i = 0; i < n; i++) {
            if (sArr[i] == 'R') w1++;
            if (w1 > w) {
                return true;
            }
            if (tArr[i] == 'L' && w1 > 1) w1--;
        }
        return false;
    }

    boolean lOchiru() {
        int w1 = sw;
        for (int i = 0; i < n; i++) {
            if (sArr[i] == 'L') w1--;
            if (w1 < 1) {
                return true;
            }
            if (tArr[i] == 'R' && w1 < w) w1++;
        }
        return false;
    }

    boolean dOchiru() {
        int h1 = sh;
        for (int i = 0; i < n; i++) {
            if (sArr[i] == 'D') h1++;
            if (h1 > h) {
                return true;
            }
            if (tArr[i] == 'U' && h1 > 1) h1--;
        }
        return false;
    }

    boolean uOchiru() {
        int h1 = sh;
        for (int i = 0; i < n; i++) {
            if (sArr[i] == 'U') h1--;
            if (h1 < 1) {
                return true;
            }
            if (tArr[i] == 'D' && h1 < h) h1++;
        }
        return false;
    }



    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
