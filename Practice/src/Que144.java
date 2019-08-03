import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author: hyl
 * @date: 2019/08/03
 **/
public class Que144 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new LinkedList<>();

        preOrderPritf(root,list);

        return list;
    }

    private void preOrderPritf(TreeNode root, List<Integer> list) {

        if (root == null){
            return;
        }
        list.add(root.val);
        
        
        preOrderPritf(root.left,list);
        preOrderPritf(root.right,list);
        
    }

    public List<Integer> preorderTraversal1(TreeNode root) {

        List<Integer> list = new LinkedList<>();

        if (root == null){
            return list;
        }

        Stack<TreeNode> toVisit = new Stack<>();
        toVisit.add(root);

        while (!toVisit.isEmpty()){
            TreeNode cur = toVisit.pop();
            list.add(cur.val);

            if (cur.right != null){
                toVisit.add(cur.right);
            }

            if (cur.left != null){
                toVisit.add(cur.left);
            }
            
            
        }


        return list;
    }
}
