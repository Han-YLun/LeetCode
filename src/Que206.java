/**
 * @author: hyl
 * @date: 2019/07/30
 **/
public class Que206 {

    static class ListNode {
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


    public ListNode reverseList1(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = null;
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        // 1. 递归终止条件
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
