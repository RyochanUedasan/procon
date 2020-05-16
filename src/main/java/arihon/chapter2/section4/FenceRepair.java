package arihon.chapter2.section4;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FenceRepair {
    void run() {
        Scanner sc = new Scanner(System.in);
        int N = 3;
        int[] L = {8, 5 ,8};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : L) {
            pq.add(i);
        }

        int cost = 0;
        while(pq.size() > 1) {
            int i1 = pq.remove();
            int i2 = pq.remove();
            cost += i1 + i2;
            pq.add(i1 + i2);
        }
        System.out.println(cost);

    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new FenceRepair().run();
    }
}
