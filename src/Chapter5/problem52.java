package Chapter5;/**
 * @author ZhouWu
 * @create 2019-08-26-15:10
 */

/**
 *@ClassName problem52
 *@Description TODO: 两个栈的第一个公共节点
 *@Version 1.0
 */
public class problem52 {

    static class ListNode {
        ListNode(int val) {
            this.val = val;
        }
        ListNode next;
        int val;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node5;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode s = findFNode(node1,node4);
        if(s!=null) {
            System.out.println(s.val);
        }
    }


    public static ListNode findFNode(ListNode a,ListNode b) {
        ListNode linka = a;
        ListNode linkb = b;

        ListNode longLink = a;
        ListNode shortLink = b;

        ListNode point1 = a;

        while(linka!=null && linkb!=null) {
            linka = linka.next;
            linkb = linkb.next;
        }

        if(linka==null) {
            longLink = b;
            shortLink = a;
            point1 = linkb;
        }else {
            point1 = linka;
        }

        ListNode point2 = longLink;

        while(point1!=null && point2!=null) {
            point1 = point1.next;
            point2 = point2.next;
        }

        ListNode point3 = shortLink;
        while(point2!=null && point3!=null) {
            if(point2==point3) {
                return point2;
            }
            point2 = point2.next;
            point3 = point3.next;
        }
        return null;
    }
}
