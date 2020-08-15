package atcoder.abc175;

import java.io.PrintWriter;
import java.util.*;

public class A {
    void run() {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String s = sc.next();

        int count = 0;
        switch (s) {
            case "SSS":
                count = 0;
                break;
            case "SSR":
            case "SRS":
            case "RSS":
            case "RSR":
                count = 1;
                break;
            case "RRS":
            case "SRR":
                count = 2;
                break;
            case "RRR":
                count = 3;
                break;
        }
        System.out.println(count);


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
