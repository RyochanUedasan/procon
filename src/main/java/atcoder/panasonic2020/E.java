package atcoder.panasonic2020;

import java.util.*;

public class E {
    String a, b, c;

    void run() {
        Scanner sc = new Scanner(System.in);
        a = sc.next();
        b = sc.next();
        c = sc.next();
        // abc acb bac bca cab cba
    }

    void dfs(int aIdx, int bIdx, int cIdx, int count) {
        if ((a.charAt(aIdx) == b.charAt(bIdx) && a.charAt(aIdx) == c.charAt(cIdx)) || a.charAt(aIdx) == '?' || b.charAt(bIdx) == '?') {
            dfs(aIdx + 1, bIdx + 1, cIdx + 1, count + 1);
        }
        if (a.charAt(aIdx) == b.charAt(bIdx) || a.charAt(aIdx) == '?' || b.charAt(bIdx) == '?') {
            dfs(aIdx + 1, bIdx + 1, cIdx, count + 1);
        }
        dfs(aIdx + 1, bIdx, cIdx, count + 1);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}
