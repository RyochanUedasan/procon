package atcoder.abc165;

import java.util.*;

public class C {
    int n, m, q;
    int[][] qArr;
    int max;
    List<Integer> list;
    void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        qArr = new int[q][4];
        for (int i = 0; i < q; i++) {
            qArr[i] = new int[]{sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt(), sc.nextInt()};
        }

        for (int i = 0 ;i < m; i++) {
            list = new ArrayList<>();
            dfs(i);
        }

        System.out.println(max);
    }

    void dfs(int i) {
        list.add(i);
        if (list.size() == n) {
            int ans = 0;

            for (int j = 0; j < q; j++) {
                int[] arr = qArr[j];
                if (list.get(arr[1]) - list.get(arr[0]) == arr[2]) {
                    ans += arr[3];
                }
            }
            max = Math.max(max, ans);
            return;
        }
        for (int j = i ; j < m; j++) {
            dfs(j);
            list.remove(list.size() - 1);
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
