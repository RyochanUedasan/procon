//package atcoder.abc136;
//
//import java.util.*;
//
//public class E {
//
//    void run() {
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        int[] arr = new int[n];
//
//
//        long sum = 0;
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//            sum += arr[i];
//        }
//        Arrays.sort(arr);
//
//        long max = Math.max(sum, k);
//
//        List<Integer> divisors = getDivisors((int) 1e9);
//
//        int answer = 1;
//        for (int pn : primeNumbers) {
//            int plusCount = 0;
//            int minusCount = 0;
//            for (int i = arr.length - 1; i >= 0; i++) {
//                arr[i];
//            }
//        }
//
//        debug(arr);
//    }
//
//    List<Integer> getDivisors(int n) {
//        List<Integer> ret = new ArrayList<>();
//        for (int i = 1; i * i <= n; i++) {
//            if (i * i == n) {
//                ret.add(i);
//            } else if (n % i == 0) {
//                ret.add(i);
//                ret.add(n / i);
//            }
//        }
//        return ret;
//    }
//
//    void debug(Object... os) {
//        System.err.println(Arrays.deepToString(os));
//    }
//
//    public static void main(String[] args) {
//        new E().run();
//    }
//}
