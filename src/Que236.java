import java.security.acl.LastOwnerException;

/**
 * @author: hyl
 * @date: 2019/08/03
 **/
public class Que236 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        return left == null ? right : right == null ? left : root;
    }
}
