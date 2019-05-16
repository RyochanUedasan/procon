package atcoder.diverta;

import java.util.*;

public class C {

    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int aEndCount = 0;
        int bStartCount = 0;
        int aEndBStartCount = 0;
        int abInnerCount = 0;


        for (int i = 0; i < n; i++) {
            String s = sc.next();

            if (s.charAt(0) == 'B' && s.charAt(s.length() - 1) == 'A') aEndBStartCount++;
            else if (s.charAt(0) == 'B') bStartCount++;
            else if (s.charAt(s.length() - 1) == 'A') aEndCount++;

            for (int j = 0; j < s.length() - 1; j++) {
                if (s.substring(j, j + 2).equals("AB")) abInnerCount++;
            }
        }

        int concatCount = 0;

        if (aEndBStartCount > 0) {
            if (aEndCount > 0) {
                concatCount++;
                aEndCount--;
            }
            if (bStartCount > 0) {
                concatCount++;
                bStartCount--;
            }
            concatCount += aEndBStartCount - 1;
        }

        concatCount += Math.min(aEndCount, bStartCount);

//        System.out.println(aEndCount);
//        System.out.println(bStartCount);
//        System.out.println(aEndBStartCount);
//        System.out.println(abInnerCount);
//        System.out.println("-------");
//        System.out.println(concatCount);
//        System.out.println(abInnerCount);

        // write your code
        System.out.println(abInnerCount + concatCount);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
