package LeetCode.String;/**
 * @author ZhouWu
 * @create 2019-09-06-22:05
 */

import java.util.Scanner;
import java.util.Stack;

/**
 *@ClassName Problem20
 *@Description TODO：简单括号匹配
 *@Version 1.0
 */
public class Problem20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean res = solution(str);
        System.out.println(res);
    }

    private static boolean solution(String s) {
        if (s.length() == 0 ) return true;
        if (s.length() == 1) return false;
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ' ') continue;
            if(!stack.isEmpty()) {
                if (isGet(s.charAt(i), stack.peek())) stack.pop();
                else {
                    stack.push(s.charAt(i));
                    continue;
                }
            }

            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') stack.push(s.charAt(i));
        }

        if (stack.isEmpty()) return true;
        return false;
    }

    public static boolean isGet(char ci, Character peek) {
        int t1 = ')' -  '(';
        int t2 = ']' -  '[';
        int t3 = '}' -  '{';
        if (ci - peek == t1 || ci - peek == t2 || ci - peek == t3) return true;
        return false;
    }

}
