/**
 * @author: hyl
 * @date: 2019/08/05
 **/
public class Que111 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {

        if (root == null){
            return 0;
        }

        if (root.left == null){
            return 1 + minDepth(root.right);
        }

        if (root.right == null){
            return 1 + minDepth(root.left);
        }

        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);

        int result = 1 + Math.min(leftMinDepth,rightMinDepth);

        return result;

    }

    public int minDepth1(TreeNode root) {

        if (root == null){
            return 0;
        }

        int left = minDepth1(root.left);
        int right = minDepth1(root.right);

        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left,right) + 1;

    }
}
