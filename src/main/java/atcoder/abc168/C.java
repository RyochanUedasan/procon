package atcoder.abc168;

import java.io.PrintWriter;
import java.util.*;

public class C {
    void run() {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int h = sc.nextInt();
        int m = sc.nextInt();

        double thetaA = 30 * h + 0.5 * m;
        double thetaB = 6 * m;
        double theta = thetaA - thetaB;
        double x = Math.sqrt(a * a + b * b - 2 * a * b * Math.cos(theta * Math.PI / 180));
        System.out.println(x);
        // out.println("Hello World");
        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
