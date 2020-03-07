    package atcoder.abc158;

    import java.util.*;

    public class A {
        void run() {
            Scanner sc = new Scanner(System.in);
            String s = sc.next();
            char x = s.charAt(0);
            boolean ans = false;
            for (char c : s.toCharArray()) {
                if (x != c) {
                    ans = true;
                }
            }
            System.out.println(ans ? "Yes" : "No");
        }

        void debug(Object... os) {
            System.err.println(Arrays.deepToString(os));
        }

        public static void main(String[] args) {
            new A().run();
        }
    }
