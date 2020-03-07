package atcoder.abc158;

import java.util.*;

public class D {
    void run() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String mid = "";
        if (s.length() >= 2) {
            mid = s.substring(1, s.length() - 1);
        }
        int q = sc.nextInt();
        StringBuffer sbHead = new StringBuffer();
        sbHead.append(s.charAt(0));
        StringBuffer sbLast = new StringBuffer();
        if (s.length() != 1) {
            sbLast.append(s.charAt(s.length() - 1));
        }
//        debug(sbHead, sbLast);
        boolean isHead = true;
        for (int i = 0; i < q; i++) {
//            debug(sbHead, sbLast);
            int t = sc.nextInt();
            if (t == 1) {
                isHead = !isHead;
                continue;
            }
            int f = sc.nextInt();
            char c = sc.next().charAt(0);
            if ((f == 1 && isHead) || (f == 2 && !isHead)) {
                sbHead.append(c);
            } else {
                sbLast.append(c);
            }
        }


        StringBuffer ans = sbHead.reverse().append(mid).append(sbLast);
        if (isHead) {
            System.out.println(ans.toString());
        } else {
            System.out.println(ans.reverse().toString());
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
