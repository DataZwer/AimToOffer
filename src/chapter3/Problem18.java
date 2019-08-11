package chapter3;
/**
 * @author ZhouWu
 * @create 2019-07-22-22:16
 */



public class Problem18 {
    public static ListNode[] ln = new ListNode[3];

    static class ListNode {
        int value;
        ListNode next;

        public void printOut(ListNode tmp) {
            while (tmp != null) {
                System.out.print(tmp.value + " ");
                tmp = tmp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < ln.length; i++) {
            ln[i] = new ListNode();
            ln[i].value = i+1;
            if (i > 0)
                ln[i - 1].next = ln[i];
        }

        try {
            ln[0].printOut(ln[0]);
            deleteNode(ln[0]);
            System.out.println("==== after delete ====");
            ln[0].printOut(ln[0]);
        } catch (NullPointerException e) {
            System.out.println("已经删完了");
        }

    }

    public static void deleteNode(ListNode toBeDeleted) {
        ListNode tmp = toBeDeleted.next;
        if (tmp != null) { // 删除节点之后有两个节点
            toBeDeleted.value = tmp.value;
            toBeDeleted.next = tmp.next;
            tmp.next = null;
        } else if (ln[0].equals(toBeDeleted)) {
            ln[0] = null;
        } else { //删除尾结点
            tmp = ln[0];
            while (!tmp.next.equals(toBeDeleted)) {
                tmp = tmp.next;
            }
            tmp.next = null;
        }
    }


}




