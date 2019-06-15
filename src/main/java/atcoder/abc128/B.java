package atcoder.abc128;

import java.util.*;

public class B {

    class Store {
        int i;
        String s;
        int p;
        public Store(int i, String s, int p) {
            this.i = i;
            this.s = s;
            this.p = p;
        }

        @Override
        public String toString() {
            return this.i + " " + this.s + " " + this.p;
        }

    }
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Store[] sArr = new Store[n];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int p = sc.nextInt();
            sArr[i] = new Store(i + 1, s, p);
        }

        Arrays.sort(sArr, (a, b) -> a.s.compareTo(b.s));


        String cur = "";
        List<Store> s2 = new ArrayList<>();
        for (Store s : sArr) {
            if (!cur.equals(s.s)) {
//                debug("1b ", s2);
                s2.sort((a, b) -> (b.p - a.p));
//                debug("1a", s2);
                for (Store ss : s2) {
                    System.out.println(ss.i);
                }
                s2 = new ArrayList<>();
            }
            cur = s.s;
            s2.add(s);
        }
        s2.sort((a, b) -> b.p - a.p);
        for (Store ss : s2) {
            System.out.println(ss.i);
        }



//        for (int i = 0; i < n; i++) {
////            debug(sArr[i]);
//            System.out.println(sArr[i].i);
//        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
