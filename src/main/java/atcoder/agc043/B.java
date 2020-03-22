package atcoder.agc043;

import java.util.*;

public class B {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        String s1 = s.substring(0, n /2);
        String s2 = s.substring(n / 2, n);
        while(s1.length() > 1) {
            StringBuffer sb = new StringBuffer();
            int current = s1.charAt(0);
            for (int j = 1; j < s1.length(); j++) {
                int next = s1.charAt(j);
                sb.append(Math.abs(next - current));
            }
            s1 = sb.toString();
        }

        while(s2.length() > 1) {
            StringBuffer sb = new StringBuffer();
            int current = s2.charAt(0);
            for (int j = 1; j < s2.length(); j++) {
                int next = s2.charAt(j);
                sb.append(Math.abs(next - current));
            }
            s2 = sb.toString();
        }

        System.out.println(Math.abs(Integer.parseInt(s1) - Integer.parseInt(s2)));
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
