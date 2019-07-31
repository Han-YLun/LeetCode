import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: hyl
 * @date: 2019/07/30
 **/
public class Que25 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        Deque<ListNode> stack = new ArrayDeque<ListNode>();
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        while (true){

            int count = 0;
            ListNode tmpNode = head;
            while(tmpNode != null && count < k){
                stack.add(tmpNode);
                tmpNode = tmpNode.next;
                count++;
            }

            if (count != k){
                p.next = head;
                break;
            }

            while (!stack.isEmpty()){
                p.next = stack.pollLast();
                p = p.next;
            }

            p.next = tmpNode;
            head = tmpNode;
            
        }


        return dummy.next;
    }
}
