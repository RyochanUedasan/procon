package aoj.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Node3 {
    Integer parent, left, right;

    public Node3() {
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    String getType() {
        if (this.parent == null) return "root";
        else if (this.left == null) return "leaf";
        else return "internal node";
    }

    public String toString(int id, int depth, List<Integer> children) {
        String childrenStr = children.stream().map(i -> i.toString()).collect(Collectors.joining(", "));
        return "node " + id
                + ": parent = " + (this.parent == null ? -1 : this.parent)
                + ", depth = " + depth
                + ", " + getType()
                + ", [" + childrenStr + "]";
    }
}

public class ALDS1_7_A {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Node3[] nodes = new Node3[n];

        // Arrays.fill(nodes, new Node3()); じゃだめ
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node3();
        }

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int k = sc.nextInt();
            int l = 0;
            for (int j = 0; j < k; j++) {
                int c = sc.nextInt();
                if (j == 0) {
                    nodes[id].left = c;
                } else {
                    nodes[l].right = c;
                }
                l = c;
                nodes[c].parent = id;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(nodes[i].toString(i, getDepth(0, i, nodes), children2(nodes[i].left, nodes, new ArrayList<>())));
        }

    }

    int getDepth(int depth, int id, Node3[] nodes) {
        if (nodes[id].parent == null) return depth;
        else return getDepth(++depth, nodes[id].parent, nodes);
    }

    List<Integer> children(Integer id, Node3[] nodes, List<Integer> list) {
        System.out.println("id:" + id);
        if (id == null) {
            return list;
        } else if (nodes[id].right == null) {
            list.add(id);
            return list;
        } else {
            list.add(id);
            return children(nodes[id].right, nodes, list);
        }
    }

    List<Integer> children2(Integer id, Node3[] nodes, List<Integer> list) {
        if (id == null) {
            return list;
        }

        list.add(id);

        Integer next = nodes[id].right;

        while (next != null) {
            list.add(next);
            next = nodes[next].right;
        }
        return list;
    }

    public static void main(String[] args) {
        new ALDS1_7_A().run();
    }

}