import java.util.ArrayList;
import java.util.List;

/**
 * @author: hyl
 * @date: 2020/03/29
 **/

public class Que1290 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 将每位上的数字记录下来,按照二进制转10进制进行转换
     * @param head
     * @return
     */
    public int getDecimalValue(ListNode head) {

        if (head == null){
            return 0;
        }

        int sum = 0;
        int index = 0;
        List<Integer> nodeValues = new ArrayList();
        while (head != null){
            nodeValues.add(head.val);
            head = head.next;
        }

        for (int i = 0; i < nodeValues.size(); i++) {
            if (nodeValues.get(i) != 0){
                sum += Math.pow(2 , nodeValues.size() - i - 1);
            }
        }

        return sum;
    }

    /**
     * 链表移向下一个节点,其实就是左移一位
     * @param head
     * @return
     */
    public int getDecimalValue1(ListNode head) {

        ListNode cur = head;
        int res = 0;
        while (cur != null){
            res <<= 1;
            res += cur.val;
            cur = cur.next;
        }
        return res;
    }


}
