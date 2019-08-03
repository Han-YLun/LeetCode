import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: hyl
 * @date: 2019/08/03
 **/

public class Que98 {


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {

        List<Integer> resultList = new ArrayList<>();

        inOrderPrintf(root,resultList);

        for (int i = 0; i < resultList.size()-1; i++) {

            if (resultList.get(i) > resultList.get(i+1)){
                return false;
            }
        }

        return true;
    }

    private void inOrderPrintf(TreeNode root, List<Integer> resultList) {

        if (root == null){
            return;
        }

        inOrderPrintf(root.left,resultList);
        resultList.add(root.val);
        inOrderPrintf(root.right,resultList);
    }




    public boolean isValidBST1(TreeNode root) {

        List<Integer> resultList = new ArrayList<>();

        return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);

    }

    private boolean isValid(TreeNode root, long minValue, long maxValue) {

        if (root == null){
            return true;
        }

        if (root.val <= minValue || root.val >= maxValue){
            return false;
        }

        return isValid(root.left,minValue,root.val) && isValid(root.right,root.val,maxValue);
    }
}
