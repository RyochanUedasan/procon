package atcoder.diverta2;

import java.util.*;

public class C {
    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PriorityQueue<Integer> qPlus = new PriorityQueue<>();
        PriorityQueue<Integer> qMinus = new PriorityQueue<>(Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (a < 0) qMinus.add(a);
            else qPlus.add(a);
            sum += Math.abs(a);
        }

//        debug(qPlus);
//        debug(qMinus);

        if (qMinus.size() == 0) {
            int min = qPlus.peek();
            System.out.println(sum - min * 2);
            int tmp = qPlus.poll();
            for (int i = 0; i < n - 1; i++) {
                int a = qPlus.poll();
                if (qPlus.isEmpty()) {
                    System.out.println(a + " " + tmp);
                } else {
                    System.out.println(tmp + " " + a);
                    tmp = tmp - a;
                }
            }
        } else if (qMinus.size() == n) {
            int min = qMinus.peek();
            System.out.println(sum - Math.abs(min) * 2);
            int tmp = qMinus.poll();
            for (int i = 0; i < n - 1; i++) {
                int a = qMinus.poll();
                System.out.println(tmp + " " + a);
                tmp = tmp - a;
            }
        } else {
            System.out.println(sum);
            int qMinusSize = qMinus.size();
            int qPlusSize = qPlus.size();
            int tmp = qPlus.poll();
            for (int i = 0; i < qMinusSize - 1; i++) {
                int a = qMinus.poll();
                System.out.println(tmp + " " + a);
                tmp = tmp - a;
            }
            qPlus.add(tmp);
            int minusTmp = qMinus.poll();
            for (int i = 0; i < qPlusSize - 1; i++) {
                int a = qPlus.poll();
                System.out.println(minusTmp + " " + a);
                minusTmp = minusTmp - a;
            }
            System.out.println(qPlus.poll() + " " + minusTmp);
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
