package arihon.chapter2.section4;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Expedition {
    void run() {
        Scanner sc = new Scanner(System.in);
        int N = 4;
        int L = 25;
        int P = 10;
        int[] aArr = {10, 14, 20, 21};
        int[] bArr = {10, 5, 2, 4};


        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int pos = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            int d = aArr[i] - pos;
            while (P < d) {
                if (pq.isEmpty()) {
                    System.out.println(-1);
                    return;
                }
                P += pq.remove();
                count++;
            }
            P = P - d;
            pq.add(bArr[i]);
            pos = aArr[i];
        }

        System.out.println(count);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new Expedition().run();
    }
}
