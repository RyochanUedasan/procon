package aoj.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ALDS1_7_D {

    int n;
    Integer[] pre;
    Integer[] in;
    int preCount;
    List<Integer> postorderList = new ArrayList<>();

    void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        pre = new Integer[n];
        in = new Integer[n];

        for (int i = 0; i < n; i++) {
            pre[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            in[i] = sc.nextInt();
        }

        preCount = 0;
        reconstruction(0, n);
        System.out.println(postorderList.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }



    void reconstruction(int l, int r) {
        if (l >= r) return;
        int c = pre[preCount++];
        int m = Arrays.asList(in).indexOf(c);
//        System.out.println(c + ", " + m);
        reconstruction(l, m);
        reconstruction(m + 1, r);
        postorderList.add(c);
    }


    public static void main(String[] args) {
        new ALDS1_7_D().run();
    }

}