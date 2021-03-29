import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author: hyl
 * @date: 2021/03/29
 **/
public class Que160 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 双指针  A+B = B+A
     * @param headA          
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != curB){
            if (curA == null){
                curA = headB;
            }else{
                curA = curA.next;
            }

            if (curB == null){
                curB = headA;
            }else{
                curB = curB.next;
            }
        }

        return curA;

    }

    /**
     * 暴力
     * 判断A中节点是否在B中
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        while (headA != null){
            ListNode cur = headB;
            while (cur != null){
                if (headA == cur){
                    return headA;
                }

                cur = cur.next;
            }

            headA = headA.next;
        }
        return null;

    }

    /**
     * 将A中的节点放到Map中,判断B中节点是否在Map中
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        HashSet<ListNode> hashSet = new HashSet<>();
        while (headA != null){
            hashSet.add(headA);
            headA = headA.next;
        }

        while (headB != null){
            if(hashSet.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;

    }




}
