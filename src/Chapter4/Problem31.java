package Chapter4;/**
 * @author ZhouWu
 * @create 2019-08-05-16:48
 */

import java.util.Stack;

/**
 *@ClassName Problem31
 *@Description TODO 栈的压入和弹出序列
 *@Version 1.0
 */
public class Problem31 {

    public static void main(String[] args) {

    }

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0 || pushA.length != popA.length) return false;
        Stack<Integer> stack = new Stack<>();
        int index = 0;

        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.empty() && stack.peek() == popA[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.empty();
    }
}
