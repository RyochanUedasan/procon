package arihon.chapter2.section4;

import java.util.Arrays;

public class Main {
    boolean[] used;
    int[] perm;
    int[] perm2;

    void run() {
        int N = 3;
        used = new boolean[N];
        perm = new int[N];
        perm2 = new int[N];
        permutation1(0, N);
    }

    public static void main(String[] args) {
        new Main().run2();
    }

    // {0, 1, 2, ... N - 1} の並び替えN!通りを生成する
    void permutation1(int pos, int n) {
        if (pos == n) {
            debug(perm);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                perm[pos] = i;
                used[i] = true;
                permutation1(pos + 1, n);
                used[i] = false;
            }
        }
        return;
    }


    char[] chars;
    String s;
    void run2() {
        s = "ABC";
        int N = s.length();
        used  = new boolean[N];
        chars = new char[N];
        perm(0, N);
    }

    void perm(int pos, int N) {
        if (pos == N) {
            debug(chars);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                char c = s.charAt(i);
                chars[pos] = c;
                used[i] = true;
                perm(pos + 1, N);
                used[i] = false;
            }
        }
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

}
