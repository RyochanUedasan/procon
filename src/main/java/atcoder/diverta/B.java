package atcoder.diverta;

import java.util.*;

public class B {

    void run() {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int G = sc.nextInt();
        int B = sc.nextInt();
        int n = sc.nextInt();

        //4504501
        int count = 0;
        int rMax = n / R;
        for (int r = 0; r <= rMax; r++) {
            int gMax = (n - R * r) / G;
            for (int g = 0; g <= gMax; g++) {
                int b = (n - R * r - G * g) / B;
                if (r * R + g * G + b * B == n) count++;
            }
        }
        // write your code
        System.out.println(count);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
