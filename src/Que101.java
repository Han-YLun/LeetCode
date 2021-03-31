/**
 * @author: hyl
 * @date: 2021/03/31
 **/
public class Que101 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric(TreeNode root) {

        if (root == null){
            return false;
        }

        return checkIsEqual(root.left,root.right);
    }

    private boolean checkIsEqual(TreeNode left, TreeNode right) {
        if (left == null && right != null){
            return false;
        }

        if (left != null && right == null){
            return false;
        }

        if (left == null && right == null){
            return true;
        }

        if (left.val != right.val){
            return false;
        }

        return checkIsEqual(left.left,right.right) && checkIsEqual(left.right,right.left);

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);

        treeNode.left.left = null;
        treeNode.left.right = new TreeNode(3);

        treeNode.right.left = null;
        treeNode.right.right = new TreeNode(3);

        boolean symmetric = new Que101().isSymmetric(treeNode);
        System.out.println(symmetric);


    }
}
