import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: hyl
 * @date: 2019/08/03
 **/
public class Que145 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> resultList = new ArrayList<Integer>();

        postOrderPrintf(root,resultList);

        return resultList;

    }

    private void postOrderPrintf(TreeNode root, List<Integer> resultList) {

        if (root == null){
            return;
        }

        postOrderPrintf(root.left,resultList);
        postOrderPrintf(root.right,resultList);
        resultList.add(root.val);

    }

    public List<Integer> postorderTraversal1(TreeNode root) {

        List<Integer> resultList = new ArrayList<Integer>();
        Stack<TreeNode> visit = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null || !visit.isEmpty()){

            while (cur != null){
                visit.push(cur);
                cur = cur.left;
            }

            cur = visit.peek();

            if (cur.right == null || cur.right == pre){

                visit.pop();
                resultList.add(cur.val);
                pre = cur;
                cur = null;
            }else{
                cur = cur.right;
            }
        }


        return resultList;

    }


}
