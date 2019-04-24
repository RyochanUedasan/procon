package aoj.algorithm;

import java.util.*;

class Process {
    String name;
    int time;
    int completedTime;

    public Process(String name, int time) {
        this.name = name;
        this.time = time;
    }

    void execute(int q) {
        this.time = this.time - q;
    }

    void setCompletedTime(int completedTime) {
        this.completedTime = completedTime;
    }

    @Override
    public String toString() {
        return this.name + " " + this.completedTime;
    }
}

class ProcessQueue {

    int head, tail, MAX;
    Process[] arr;

    public ProcessQueue(int max) {
        this.MAX = max;
        arr = new Process[MAX];
    }

    void initialize() {
        head = 0;
        tail = 0;
    }

    boolean isEmpty() {
        return head ==tail;
    }

    boolean isFull() {
        return head == (tail + 1) % MAX;
    } // あー、+1したときに、MAXを超えるときがあるのか

    void enqueue(Process x) {
        if (isFull()) {
            throw new RuntimeException("オーバーフロー");
        }
        arr[tail] = x;
        if (tail + 1 == MAX) {
            tail = 0;
        } else {
            tail++;
        }
    }

    Process dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("アンダーフロー");
        }
        Process x = arr[head];
        if (head + 1 == MAX) {
            head = 0;
        } else {
            head++;
        }
        return x;
    }
}

public class ALDS1_3_B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        ProcessQueue queue = new ProcessQueue(100000);
        ProcessQueue completed = new ProcessQueue(100000);
        queue.initialize();
        completed.initialize();

        for (int i = 0; i < n; i++) {
            queue.enqueue(new Process(sc.next(), sc.nextInt()));
        }

        int consumedTime = 0;

        while (!queue.isEmpty()) {
            Process p = queue.dequeue();

            if (p.time <= q) {
                consumedTime += p.time;
                p.setCompletedTime(consumedTime);
                completed.enqueue(p);
            } else {
                consumedTime += q;
                p.execute(q);
                queue.enqueue(p);
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(completed.dequeue());
        }
    }
}
