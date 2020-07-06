package atcoder.abc169;

import java.io.PrintWriter;
import java.util.*;

public class E {
    void run() {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();

        boolean isEven = n % 2 == 0;

        int[] aArr = new int[n];
        int[] bArr = new int[n];

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            aArr[i] = a;
            bArr[i] = b;
        }

        Arrays.sort(aArr);
        Arrays.sort(bArr);
//        debug(aArr);
        int ans;
        double min, max;
        n = n - 1;
        if (isEven) {
            min = (aArr[n / 2] + aArr[(n / 2) + 1]) / (double) 2;
            max = (bArr[n / 2] + bArr[(n / 2) + 1]) / (double) 2;
            ans = (int) ((max - min) * 2) + 1;
        } else {
            min = aArr[n / 2];
            max = bArr[n / 2];
            ans = (int) (max - min) + 1;
        }
        System.out.println(ans);

        // out.println("Hello World");
        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}
