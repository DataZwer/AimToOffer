package chapter3;
/**
 * @author ZhouWu
 * @create 2019-08-01-9:49
 */

/**
 *@ClassName Problem25
 *@Description TODO
 *@Version 1.0
 */
public class Problem25 {
    public static class ListNode {
        public int value;
        public ListNode next;
    }

    public static void main(String[] args) {

    }

    public static ListNode Merge(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null) return pHead1;
        if (pHead2 == null) return pHead2;

        ListNode tmp = null;
        if (pHead1.value < pHead2.value) {
            tmp = pHead1;
            tmp.next = Merge(pHead1.next, pHead2);
        } else {
            tmp = pHead2;
            tmp.next = Merge(pHead1, pHead2.next);
        }
        return tmp;
    }
}
