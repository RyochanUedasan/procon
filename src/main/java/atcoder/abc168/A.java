package atcoder.abc168;

import java.io.PrintWriter;
import java.util.*;

public class A {
    void run() {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        switch (n % 10) {
            case 2:
            case 4:
            case 5:
            case 7:
            case 9:
                System.out.println("hon");
                return;
            case 0:
            case 1:
            case 6:
            case 8:
                System.out.println("pon");
                return;
            case 3:
                System.out.println("bon");
                return;
        }

        // out.println("Hello World");
        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }
}
