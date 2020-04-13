package atcoder.abc162;

import java.util.*;

public class D {
    void run() {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        String s = sc.next();
        long rCount = 0;
        long gCount = 0;
        long bCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'R') {
                rCount++;
            } else if (s.charAt(i) == 'G') {
                gCount++;
            } else {
                bCount++;
            }
        }



        long opposite = 0;

        // 同じものが2個ある
        opposite += (rCount * (rCount - 1) /  2) * (n - rCount);
        opposite += (gCount * (gCount - 1) /  2) * (n - gCount);
        opposite += (bCount * (bCount - 1) /  2) * (n - bCount);

//        debug((long)4000 * (4000 - 1) * (4000 - 2) / 6);
        // 3個
        opposite += (rCount * (rCount - 1) * (rCount - 2) / 6);
        opposite += (gCount * (gCount - 1) * (gCount - 2) / 6);
        opposite += (bCount * (bCount - 1) * (bCount - 2) / 6);

        // j - i == k - j
        for (int i = 2; i < n; i = i + 2) {
            for (int j = 0; j <= n - i - 1; j++) {
                if (s.charAt(j) != s.charAt(j + (i / 2)) && s.charAt(j + (i / 2)) != s.charAt(j + i) && s.charAt(j) != s.charAt(j + i)) {
                    opposite++;
                }
            }
        }

        long total = n * (n - 1) * (n - 2) / 6;
        debug(total);

        System.out.println(total - opposite);


    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
