import java.util.ArrayList;
import java.util.List;

/**
 * @author: hyl
 * @date: 2021/04/08
 **/
public class Que234 {
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
     * 将链表中的元素放在list中,然后判断list是否为回文
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        for (int start = 0; start < list.size() / 2; start++) {
            int end = list.size() - start - 1;
            if (!list.get(start).equals(list.get(end))){
                 return false;
            }
        }
        return true;

    }
}
