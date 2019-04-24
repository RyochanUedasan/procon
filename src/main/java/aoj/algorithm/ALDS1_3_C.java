package aoj.algorithm;

import java.util.Scanner;

class IntDoublyLinkedList {
    Node head;
    Node last;
    int size;

    public IntDoublyLinkedList() {
        this.size = 0;
        this.head = null;
        this.last = null;
    }

    private class Node {
        int element;
        Node next;
        Node prev;

        public Node(int element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void insert(int element) {
        Node tmp = new Node(element, head, null);
        if (head != null) head.prev = tmp;
        head = tmp;
        if (last == null) last = tmp;
        size++;
    }

    public Node listSearch(int element) {
        Node target = head;
        while (target != null && target.element != element) {
            target = target.next;
        }
        return target;
    }

    public void delete(int element) {
        Node target = listSearch(element);
        if (target != null) {
            if (target.prev != null) {
                target.prev.next = target.next;
            } else {
                target.next.prev = target.prev;
                this.head = target.next;
            }
            if (target.next != null ) {
                target.next.prev = target.prev;
            } else {
                target.prev.next = target.next;
                this.last = target.prev;
            }
            size--;
        }
    }

    public void deleteFirst() {
        if (isEmpty()) {
            throw new RuntimeException("no elements.");
        }
        if (head.next != null) {
            head.next.prev = null;
            this.head = head.next;
        } else {
            this.head = null;
        }
        size--;
    }

    public void deleteLast() {
        if (isEmpty()) {
            throw new RuntimeException("no elements");
        }

        if (last.prev != null) {
            last.prev.next = null;
            this.last = last.prev;
        }

        size--;
    }

    public String formatted() {
        StringBuffer sb = new StringBuffer();
        Node target = this.head;
        sb.append(target.element);
        while (target.next != null) {
            target = target.next;
            sb.append(" ");
            sb.append(target.element);
        }
        return sb.toString();
    }

}

public class ALDS1_3_C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        IntDoublyLinkedList list = new IntDoublyLinkedList();

        for (int i = 0; i < n; i++) {
            String command = sc.next();
            if (command.equals("insert")) {
                int x = sc.nextInt();
                list.insert(x);
            } else if (command.equals("delete")) {
                int x = sc.nextInt();
                list.delete(x);
            } else if (command.equals("deleteFirst")) {
                list.deleteFirst();
            } else if (command.equals("deleteLast")) {
                list.deleteLast();
            }
        }

        System.out.println(list.formatted());
    }
}
