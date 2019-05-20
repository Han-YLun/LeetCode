import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Han-YLun
 * @date 2019/5/11 0011
 * @Version 1.0
 */




public class Que2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode curNode = null;
        ListNode result = null;
        boolean carryBit = false;

        while (l1 != null || l2 != null){
            int a = 0,
                b = 0;

            if (l1 != null){
                a = l1.val;
                l1 = l1.next;
            }

            if (l2 != null){
                b = l2.val;
                l2 = l2.next;
            }

            int sum = (carryBit ? 1 : 0) + a +b;
            int value = sum%10;
            carryBit = sum >= 10;

            if (result == null){
               result = new ListNode(value);
               curNode = result;
            }else{
               curNode.next = new ListNode(value);
               curNode = curNode.next;
            }
        }

        if (carryBit){
            curNode.next = new ListNode(1);
        }

        return result;
    }
}
