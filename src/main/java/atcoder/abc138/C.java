package atcoder.abc138;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        double sum = (arr[0] + arr[1]) / (double) 2;
        for (int i = 2; i < n; i++) {
            sum = (sum + arr[i]) / (double) 2;
        }

        System.out.println(sum);
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
