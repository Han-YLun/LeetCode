import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: hyl
 * @date: 2019/08/05
 **/
public class Que102 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //BFS
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> resultList = new ArrayList<List<Integer>>();

        if (root == null){
            return  resultList;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> list = new ArrayList<Integer>();

            for (int i = 0; i < levelSize ; i++) {
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);

                if (treeNode.left != null){
                    queue.add(treeNode.left);
                }

                if (treeNode.right != null){
                    queue.add(treeNode.right);
                }
            }

            resultList.add(list);
        }

        return resultList;
    }

    //DFS
    public List<List<Integer>> levelOrder1(TreeNode root) {

        List<List<Integer>> resultList = new ArrayList<List<Integer>>();

        if (root == null){
            return  resultList;
        }

        dfs(root,0,resultList);

        return resultList;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> resultList) {

        if (node == null){
            return;
        }

        if (resultList.size() < level + 1){
            resultList.add(new ArrayList<Integer>());
        }

        resultList.get(level).add(node.val);

        dfs(node.left,level+1,resultList);
        dfs(node.right,level+1,resultList);
    }
}
