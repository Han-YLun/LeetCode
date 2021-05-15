/**
 * @author: hyl
 * @date: 2021/05/15
 **/
public class Que116 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

    public Node connect(Node root) {
        if (root == null || root.left == null || root.right == null) {
            return root;
        }


        //先连接单节点树内部的
        root.left.next = root.right;
        //连接临接树
        if (root.next != null){
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;

    }
}
