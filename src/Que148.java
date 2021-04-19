import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: hyl
 * @date: 2021/04/19
 **/
public class Que148 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 现将链表放到数组中排序,然后根据排序的顺序重新替换链表中的值
     * 时间复杂度 : O(N * log(N))
     * 空间复杂度 : O(N)
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //将链表中的值放到List中
        List<Integer> list = new ArrayList<>();
        ListNode curNode = head;
        while (curNode != null) {
            list.add(curNode.val);
            curNode = curNode.next;
        }

        //对数组进行排序
        Collections.sort(list);

        //使用list重新构造数组
        curNode = head;
        int index = 0;
        while (curNode != null) {
            curNode.val = list.get(index++);
            curNode = curNode.next;
        }
        return head;
    }
}
