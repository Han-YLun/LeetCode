/**
 * @author: hyl
 * @date: 2021/03/23
 **/



public class Que108 {

    class TreeNode {
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

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0 , nums.length-1);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if (left > right){
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfs(nums,left,mid-1);
        node.right = dfs(nums,mid+1, right);
        return node;
    }

}
