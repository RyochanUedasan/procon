package arihon.chapter2.section2.part3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * problem: https://atcoder.jp/contests/abc076/tasks/abc076_c
 * solved: https://atcoder.jp/contests/abc076/submissions/11411237
 */
public class ABC076_C {


    boolean equals (String s, String t) {
//        debug(s, t);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '?' && s.charAt(i) != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int index = -1;
        for (int i = s.length() - t.length(); i >= 0; i--) {
            if (equals(s.substring(i, i + t.length()), t)) {
                index = i;
                break;
            }
        }
//        debug(index);
        if (index == -1) {
            System.out.println("UNRESTORABLE");
            return;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < index; i++) {
            char c = s.charAt(i);
            sb.append(c == '?' ? 'a' : c);
        }

        sb.append(t);

        for (int i = index + t.length(); i < s.length(); i++) {
            char c = s.charAt(i);
            sb.append(c == '?' ? 'a' : c);
        }

        System.out.println(sb.toString());

    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new ABC076_C().run();
    }
}
