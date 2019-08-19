package atcoder.abc131;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class D {
    class Job{
        int a, b;
        public Job(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return this.a +  " " + this.b;
        }
    }
    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PriorityQueue<Job> jQ = new PriorityQueue<>((o1, o2) -> o1.b - o2.b);


        for (int i = 0; i < n; i++) {
            jQ.add(new Job(sc.nextInt(), sc.nextInt()));
        }

        int time = 0;

        boolean isCompleted = true;
        for (int i = 0; i < n; i++) {
            Job j = jQ.poll();
            time = time + j.a;
            if (time > j.b) {
                isCompleted = false;
                break;
            }
        }

        System.out.println(isCompleted ? "Yes" : "No");
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
