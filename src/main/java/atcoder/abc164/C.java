package atcoder.abc164;

import java.util.*;

public class C {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.next());
        }
        System.out.println(set.size());
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
