package LeetCode.String;/**
 * @author ZhouWu
 * @create 2019-09-07-14:58
 */

import org.junit.Test;

import java.util.Scanner;
import java.util.Stack;

/**
 *@ClassName Problem20_1
 *@Description TODO
 *@Version 1.0
 */

public class Problem20_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 5;
        while (t > 0) {
            String str = sc.nextLine();
            boolean res = solution(str);
            System.out.println(res);
            t--;
        }
    }

    public static boolean solution(String s) {
        if (s.length() == 0 ) return true;
        String str = "";
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) != ' ') str += s.charAt(i);
        if (str.length() == 1) return false;
        Stack<Character> stack = new Stack<Character>();
        stack.push(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (!stack.isEmpty() && isRight(stack.peek(), str.charAt(i))) stack.pop();
            else stack.push(str.charAt(i));
        }
        if (stack.isEmpty()) return true;
        return false;
    }

    public static boolean isRight(Character peek, char ci) {
        if (peek == '(' && ci == ')') return true;
        if (peek == '[' && ci == ']') return true;
        if (peek == '{' && ci == '}') return true;
        return false;
    }

    @Test
    public void test() {
        String s = "";
        char[] c = {'a', 'b', 'c'};
        for (int i = 0; i < c.length; i++) s += c[i];
        System.out.println(s);
    }
}
