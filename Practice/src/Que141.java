/**
 * @author: hyl
 * @date: 2019/07/30
 **/
public class Que141 {
    
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {


        if (head == null || head.next == null ) {
            return false;
        }


        ListNode slowNode = head;
        ListNode fastNode = head;

        while (slowNode != null && fastNode.next != null && fastNode.next.next != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;

            if (slowNode == fastNode){
                return true;
            }
        }

        return false;
    }
}
