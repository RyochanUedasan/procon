package aoj.algorithm;

import java.util.ArrayDeque;
import java.util.Scanner;

class Area {
    int startIdx;
    int value;

    public Area(int startIdx, int value) {
        this.startIdx = startIdx;
        this.value = value;
    }
}

public class ALDS1_3_D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Area> areaStack = new ArrayDeque<>();

        int sum = 0;
        char[] input = sc.next().toCharArray();
        for (int i = 0; i < input.length; i++) {
            if (input[i] == '\\') {
                stack.push(i);
            } else if (!stack.isEmpty() && input[i] == '/') {
                int oppositeIdx = stack.pop();
                sum += i - oppositeIdx;

                int a = i - oppositeIdx;
                while (!areaStack.isEmpty() && areaStack.peek().startIdx > oppositeIdx) {
                    a += areaStack.pop().value;
                }
                areaStack.push(new Area(oppositeIdx, a));
            }
        }

        System.out.println(sum);

        StringBuffer sb = new StringBuffer();
        int areaStackSize = areaStack.size();
        sb.append(areaStackSize);

        for (int i = 0; i < areaStackSize; i++) {
            sb.append(" ");
            sb.append(areaStack.removeLast().value);
        }
        System.out.println(sb);
    }
}
