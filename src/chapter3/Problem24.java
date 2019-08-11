package chapter3;/**
 * @author ZhouWu
 * @create 2019-07-31-21:12
 */

import java.util.List;

/**
 *@ClassName Problem24
 *@Description TODO
 *@Version 1.0
 */
public class Problem24 {
    public static class ListNode {
        public int value;
        public ListNode next;
    }

    public static ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        ListNode pNode = head;
        ListNode preNode = null;
        ListNode revhead = null;

        while (pNode != null) {
            ListNode pNext = pNode.next;
            if (pNext == null) revhead = pNode;

            pNode.next = preNode;
            preNode = pNode;
            pNode = pNext;
        }

        return revhead;
    }



}
