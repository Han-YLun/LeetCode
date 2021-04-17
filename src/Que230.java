import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: hyl
 * @date: 2021/04/17
 **/
public class Que230 {

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

    /**
     * 二叉搜索树中第K小的元素
     * 先将二叉搜索树通过中序遍历转为数组,排序完成之后取第K小的元素即可
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {

        List<Integer> list = new ArrayList<>();
        getArrayByBinarySearchTree(root, list);
        Collections.sort(list);

        if (k > list.size()) {
            return 0;
        }
        return list.get(k - 1);
    }

    private void getArrayByBinarySearchTree(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        getArrayByBinarySearchTree(root.left, list);
        list.add(root.val);
        getArrayByBinarySearchTree(root.right, list);

    }

    /**
     * 二叉搜索树中第K小的元素
     * 通过迭代替换递归,查到就返回
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest1(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(4);

        treeNode.right = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        System.out.println(new Que230().kthSmallest1(treeNode, 5));

    }

}

