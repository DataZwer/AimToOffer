package Chapter4;/**
 * @author ZhouWu
 * @create 2019-08-05-16:10
 */

import java.util.Stack;

/**
 *@ClassName problem30
 *@Description TODO
 *@Version 1.0
 */
public class problem30 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> temp = new Stack<>();
    int min = Integer.MAX_VALUE;

    public void push(int node) {
        stack.push(node);
        if (node < min) {
            temp.push(node);
            min = node;
        } else {
            temp.push(min);
        }
    }

    public void pop() {
        stack.pop();
        temp.pop();
    }

    public int min() {
        int m = temp.pop();
        temp.push(m);
        return m;
    }

    public static void main(String[] args) {

    }






}
