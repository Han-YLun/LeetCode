import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: hyl
 * @date: 2021/04/19
 **/
public class Que148 {

    public static class ListNode {
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
     *
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

    /**
     * 自顶向下进行分治进行排序
     * 时间复杂度 : O(N * log(N))
     * 空间复杂度 : O(log(N))
     *
     * @param head
     * @return
     */
    public ListNode sortList1(ListNode head) {
        return sortListNode(head, null);
    }

    private ListNode sortListNode(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }

        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail){
                fast = fast.next;
            }
        }

        ListNode mid = slow;
        ListNode list1 = sortListNode(head, mid);
        ListNode list2 = sortListNode(mid, tail);
        return merge(list1, list2);
    }
    /**
     * 合并链表list1和list2
     *
     * @param list1
     * @param list2
     * @return
     */
    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode temp = dummyHead, temp1 = list1, temp2 = list2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }

        if (temp1 != null) {
            temp.next = temp1;
        }

        if (temp2 != null) {
            temp.next = temp2;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        //[4,2,1,3]
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(3);

        new Que148().sortList1(listNode);


    }

    /**
     * 自底向上进行排序
     * 时间复杂度 : O(N * log(N))
     * 空间复杂度 : O(1)
     * @param head
     * @return
     */
    public ListNode sortList12(ListNode head) {
        return sortListNode(head, null);
    }


}
