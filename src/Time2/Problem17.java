package Time2;/**
 * @author ZhouWu
 * @create 2019-09-27-22:54
 */

import java.util.Stack;

/**
 *@ClassName Problem17
 *@Description TODO
 *@Version 1.0
 */
public class Problem17 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }


    public static int[] printListReversingly(ListNode head) {
        if (head == null) return new int[]{};
        Stack<ListNode> stack = new Stack<ListNode>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int[] arr = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) arr[i++] = stack.pop().val;
        return arr;
    }



}
