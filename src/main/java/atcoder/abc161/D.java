package atcoder.abc161;

import java.util.*;

public class D {
    int k;
    Queue<String> q;

    void run() {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        q = new ArrayDeque<>();
        q.addAll(Arrays.asList(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
        String next = "";
        int count = 0;

        while (count < k) {
            next = q.remove();
//            debug(q);
            count++;
            char last = next.charAt(next.length() - 1);
            if (last != '0') {
//                debug(last);
//                debug(next +  (Character.getNumericValue(last) - 1));
                q.add(next + (Character.getNumericValue(last) - 1));
            }
            q.add(next + Character.getNumericValue(last));
            if (last != '9') {

                q.add(next + (Character.getNumericValue(last) + 1));
            }
//            debug(q);

        }

        System.out.println(next);

    }

    void bfs() {


    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
