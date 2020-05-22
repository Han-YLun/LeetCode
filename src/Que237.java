/**
 * @author: hyl
 * @date: 2020/05/21
 **/


public class Que237 {
    /**
     * 无法获取node的pre结点，因为把当前节点的值变为和下一个节点的值一样，然后跳过下一个节点即可
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
