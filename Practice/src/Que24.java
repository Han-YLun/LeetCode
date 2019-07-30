/**
 * @author: hyl
 * @date: 2019/07/30
 **/
public class Que24 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        ListNode tempNode = head.next;

        head.next = swapPairs(tempNode.next);
        tempNode.next = head;
       
        return tempNode;
    }
}
