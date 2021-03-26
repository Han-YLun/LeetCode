/**
 * @author: hyl
 * @date: 2019/07/30
 **/
public class Que206 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode preNode = head;
        ListNode curNode = head.next;
        ListNode nextNode = curNode.next;

        while (curNode != null) {
            curNode.next = preNode;

            preNode = curNode;
            curNode = nextNode;
            if (nextNode != null) {
                nextNode = nextNode.next;
            }
        }

        head.next = null;
        head = preNode;
        return head;
    }

}
