package atcoder.abc136;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class D {

    class Sep {
        int rCount, lCount, rlStartIdx;
        public Sep(int rCount, int lCount, int rlStartIdx) {
            this.rCount = rCount;
            this.lCount = lCount;
            this.rlStartIdx = rlStartIdx;
        }

        int lValue() {
            if (this.rCount == this.lCount) {
                return this.rCount;
            } else if (this.rCount % 2 == 0) {
                return (this.rCount + this.lCount) / 2;
            } else {
                return (this.rCount + this.lCount) / 2 + (this.rCount + this.lCount) % 2;
            }
        }

        int rValue() {
            if (this.rCount == this.lCount) {
                return this.rCount;
            } else if (this.rCount % 2 == 0) {
                return (this.rCount + this.lCount) / 2 + (this.rCount + this.lCount) % 2;
            } else {
                return (this.rCount + this.lCount) / 2 ;
            }
        }
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        List<Sep> sepList = new ArrayList<>();

        int rlStartIdx = 0;
        int rCount = 0;
        int lCount = 0;
        for (int i = 0 ; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                rCount++;
                if (s.charAt(i + 1) == 'L') {
                    rlStartIdx = i;
                }
            } else {
                lCount++;
                if (i == s.length() - 1 || s.charAt(i + 1) == 'R') {
                    sepList.add(new Sep(rCount, lCount, rlStartIdx));
                    rlStartIdx = 0;
                    rCount = 0;
                    lCount = 0;
                }
            }
        }

        int[] ans = new int[s.length()];

        for (Sep sep : sepList) {
            ans[sep.rlStartIdx] = sep.lValue();
            ans[sep.rlStartIdx + 1] = sep.rValue();
        }

        for (int i = 0 ; i < s.length() - 1; i++) {
            System.out.print(ans[i]);
            System.out.print(" ");
        }
        System.out.println(ans[s.length() - 1]);

    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
