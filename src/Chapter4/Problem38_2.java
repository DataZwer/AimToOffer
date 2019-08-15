package Chapter4;/**
 * @author ZhouWu
 * @create 2019-08-13-15:18
 */

import java.util.Arrays;
import java.util.Stack;

/**
 *@ClassName Problem38_2
 *@Description TODO：字符串的组合 a, b, c, ab, ac, bc. abc
 *@Version 1.0
 */
public class Problem38_2 {
    public static void main(String[] args) {
        String str = "abcd";
        char[] pstr = str.toCharArray();
        combine(pstr);

    }

    public static void combine(char chs[]) {
        if (chs.length == 0) return;

        Stack<Character> stack = new Stack<>();
        for (int i = 1; i <= chs.length; i++) {
            combine(chs, 0, i, stack);
        }
    }

    private static void combine(char[] chs, int begin, int number, Stack<Character> stack) {
        if (number == 0) {
            System.out.println(stack.toString());
            return;
        }

        if (begin == chs.length) {
            return;
        }

        stack.push(chs[begin]); // 放回去
        combine(chs, begin + 1, number - 1, stack);
        stack.pop();  // 不放回去
        combine(chs, begin + 1, number, stack);

    }


}
