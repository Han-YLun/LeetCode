import java.util.HashSet;
import java.util.Set;

/**
 * @author: hyl
 * @date: 2019/07/30
 **/
public class Que142 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {

        Set<ListNode> visited = new HashSet<ListNode>();

        ListNode node = head;
        while (node != null){
            if (visited.contains(node)){
                return node;
            }

            visited.add(node);
            node = node.next;
        }
        return null;
    }
}
