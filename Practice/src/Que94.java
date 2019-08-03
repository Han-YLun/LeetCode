import com.sun.org.apache.xml.internal.utils.StringToStringTableVector;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: hyl
 * @date: 2019/08/03
 **/
public class Que94 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {


        List<Integer> list = new ArrayList<Integer>();

        inOrderPrintf(root,list);

        return list;
    }

    private void inOrderPrintf(TreeNode root, List<Integer> list) {

        if (root == null){
            return;
        }

        inOrderPrintf(root.left,list);
        list.add(root.val);
        inOrderPrintf(root.right,list);

    }

    public List<Integer> inorderTraversal1(TreeNode root) {


        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> visit = new Stack<>();
        TreeNode cur = root;

        if (root == null){
            return list;
        }


        while (cur != null || !visit.isEmpty()){
            while (cur != null){
                visit.push(cur);
                cur = cur.left;
            }

            cur = visit.pop();
            list.add(cur.val);
            cur = cur.right;

        }
        return list;
    }
}
