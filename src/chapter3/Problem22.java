/**
 * @author ZhouWu
 * @create 2019-07-26-15:47
 */
package chapter3;

/**
 *@ClassName Problem22
 *@Description TODO
 *@Version 1.0
 */
public class Problem22 {

    public static class ListNode {
        int value;
        ListNode next;
    }
    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[10];

        listNodes[0] = new ListNode();
        listNodes[0].value = 1;

        for (int i = 1; i < 10; i++) {
            listNodes[i] = new ListNode();
            listNodes[i].value = i+1;
            listNodes[i-1].next = listNodes[i];
        }

        ListNode head = listNodes[0];
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }

        System.out.println();
        try {
            System.out.println(FindKthToTail(listNodes[0], (byte) 3).value);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


    }

    public static ListNode FindKthToTail(ListNode head, byte k) {
        if (head == null || k == 0) return null; // 判断空

        ListNode pAhead = head;
        ListNode pBehind = null;

        for (byte i = 0; i < k-1; ++i) {
            if (pAhead.next != null) pAhead = pAhead.next;
            else {
                return null; // 若 k > 节点数
            }
        }

        pBehind = head;
        while (pAhead.next != null) {
            pAhead = pAhead.next;
            pBehind = pBehind.next;
        }
        return pBehind;
    }



}
