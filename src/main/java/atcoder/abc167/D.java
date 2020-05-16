package atcoder.abc167;

import java.io.PrintWriter;
import java.util.*;

public class D {
    void run() {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        long k = sc.nextLong();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt() - 1;
        }

        boolean[] visited = new boolean[n + 1];
        int[] tele = new int[n + 1];
        int current = 0;
        int index = 0;
        int loopStart;
        while (true) {
            if (visited[current]) {
                loopStart = current;
                break;
            }
            visited[current] = true;
//            debug(visited, current);
            index++;
            current = arr[current];
            tele[index] = current;
        }

//        debug(loopStart, index);

        int loopStartIdx = 0;
        for (int i = 0; i < n; i++) {
            if (tele[i] == loopStart) {
                loopStartIdx = i;
                break;
            }
        }

        int loopCount = index - loopStartIdx;
        int noLoopCount = loopStartIdx;
//        debug(loopCount, noLoopCount);
//        debug(tele);
        long j = k > noLoopCount ? noLoopCount + (k - noLoopCount) % loopCount : k;
        System.out.println(tele[(int)j] + 1);







        // out.println("Hello World");
        out.flush();    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
