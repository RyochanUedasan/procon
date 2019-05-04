package aoj.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class ALDS1_8_B {

    Node rootNode;

    class Node {
        int value;
        Node p, l, r;

        public Node(int value) {
            this.value = value;
        }
    }

    void insert(Node n) {
        if (rootNode == null) {
            rootNode = n;
            return;
        }
        Node x = rootNode;
        Node y = x;
        while (x != null) {
            y = x;
            n.p = x;
            if (x.value < n.value) {
                x = x.r;
            } else {
                x = x.l;
            }
        }
        if (y.value < n.value) {
            y.r = n;
        } else {
            y.l = n;
        }
    }

    void find(int k) {
        Node x = rootNode;
        while (x != null) {
            if (x.value == k) {
                System.out.println("yes");
                return;
            } else if (x.value > k) {
                x = x.l;
            } else {
                x = x.r;
            }
        }
        System.out.println("no");
    }

    void print() {
        preorder(rootNode);
        System.out.println();
        inorder(rootNode);
        System.out.println();
    }

    void inorder(Node n) {
        if (n == null) return;
        System.out.print(" " + n.value);
        inorder(n.l);
        inorder(n.r);
    }

    void preorder(Node n) {
        if (n == null) return;
        preorder(n.l);
        System.out.print(" " + n.value);
        preorder(n.r);
    }

    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if (s.equals("insert")) {
                int k = sc.nextInt();
                insert(new Node(k));
            } else if (s.equals("print")) {
                print();
            } else if (s.equals("find")) {
                int k = sc.nextInt();
                find(k);
            }
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new ALDS1_8_B().run();
    }
}
