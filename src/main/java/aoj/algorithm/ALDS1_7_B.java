package aoj.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Node2 {
    Integer parent, left, right;

    public Node2() {
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    int getParent() {
        return this.parent == null ? -1 : this.parent;
    }

    int getDegree() {
        int count = 0;
        if (this.left != null) count++;
        if (this.right != null) count++;
        return count;
    }

    String getType() {
        if (this.parent == null) {
            return "root";
        } else if (this.left  == null && this.right == null) {
            return "leaf";
        } else {
            return "internal node";
        }
    }
}

public class ALDS1_7_B {

    static Node2[] nodes;

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nodes = new Node2[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node2();
        }

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();

            if (r != -1) {
                nodes[id].right = r;
                nodes[r].parent = id;
            }
            if (l != -1) {
                nodes[id].left = l;
                nodes[l].parent = id;
            }
        }

        int[] heights = new int[n];
        int[] depths = new int[n];

        int rootId = 0;
        for (int i = 0; i < n; i++) {
            if (nodes[i].getType().equals("root")) {
                rootId = i;
                break;
            }
        }


        setHeight(heights, rootId);
        setDepth(depths, rootId, 0);

        for (int i = 0; i < n; i++) {
            Node2 node = nodes[i];
            System.out.println(
                    "node " + i
                            + ": parent = " + node.getParent()
                            + ", sibling = " + getSibling(i)
                            + ", degree = " + node.getDegree()
                            + ", depth = " + depths[i]
                    + ", height = " + heights[i]
                    + ", " + node.getType()
            );
        }
    }

    int setHeight(int[] heights, int u) {
        int h1 = 0;
        int h2 = 0;
        if (nodes[u].right != null) {
            h1 = setHeight(heights, nodes[u].right) + 1;
        }
        if (nodes[u].left != null) {
            h2 = setHeight(heights, nodes[u].left) + 1;
        }
        return heights[u] = Math.max(h1, h2);
    }

    void setDepth(int[] depths, Integer u, Integer d) {
        if (u == null) {
            return;
        }
        depths[u] = d;
        setDepth(depths, nodes[u].left, d + 1);
        setDepth(depths, nodes[u].right, d + 1);
    }

    int getSibling(int u) {
        if (nodes[u].parent == null) {
            return -1;
        } else {
            Node2 parent = nodes[nodes[u].parent];
            if (parent.left != null && parent.left != u) {
                return parent.left;
            }
            if (parent.right != null && parent.right != u) {
                return parent.right;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        new ALDS1_7_B().run();
    }

}