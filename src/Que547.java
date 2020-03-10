import java.util.Arrays;

/**
 * @author: hyl
 * @date: 2019/08/11
 **/
public class Que547 {

    private int[] parent;

    public int findCircleNum(int[][] M) {

        int N = M.length;
        parent = new int[N];

        //默认-1为根
        Arrays.fill(parent,-1);

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {

                //对于所有学生，有M[i][i] = 1。
                // 有M[i][j] = 1，则有M[j][i] = 1。 只要遍历对角线上半部分就可以了
                if (M[i][j] == 1){
                    union(i,j);
                }
            }
            
        }

        int cnt = 0;
        for (int i : parent) {
            if (i == -1){
                cnt++;
            }
        }
        return cnt;
    }

    private void union(int x, int y) {

        int xParent = findRoot(x);
        int yParent = findRoot(y);

        //如果不在一个集合中,需要合并
        if (xParent != yParent){
            parent[yParent] = xParent;
        }

    }

    private int findRoot(int id) {

        if (parent[id] == -1){
            return id;
        }

        parent[id] = findRoot(parent[id]);
        return parent[id];
    }

    public static void main(String[] args) {
        new Que547().findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}) ;
    }
}
