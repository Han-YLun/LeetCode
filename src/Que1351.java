/**
 * @author: hyl
 * @date: 2020/05/24
 **/
public class Que1351 {
    public int countNegatives(int[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = grid[0].length-1; j >=0 ; j--) {
                if (grid[i][j] < 0){
                    sum++;
                }else if (grid[i][j] >= 0){
                    break;
                }
            }
        }
        return sum;

    }

}
