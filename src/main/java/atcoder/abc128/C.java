package atcoder.abc128;

import java.util.*;

public class C {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer>[] list = new List[m];
        int[] pArr = new int[m];


        for (int i = 0; i < m; i++) {
            list[i] = new ArrayList<Integer>();
            int k = sc.nextInt();
            for (int j = 0; j < k; j++) {
                list[i].add(sc.nextInt());
            }
        }
        for (int i = 0; i < m; i++) {
            pArr[i] = sc.nextInt();
        }


        int count = 0;
        String format = "%0" + n + "d";
//        debug(format);
        for (int i = 0; i < Math.pow(2, n); i++) {
            String bin = String.format(format, Integer.parseInt(Integer.toBinaryString(i)));
//            debug(bin);
            boolean isValid = true;
            for (int j = 0; j < m; j++) {
                int sum = 0;
//                debug(list[j]);
                for (int k : list[j]) {
                    sum += bin.charAt(k - 1) == '1' ? 1 : 0;
                }
                if (sum % 2 != pArr[j]) isValid = false;
            }
            if (isValid) count++;
        }
        System.out.println(count);


//        System.out.println(sum / (n * Math.pow(2, indexMax)));
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
