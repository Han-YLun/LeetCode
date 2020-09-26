/**
 * @author: hyl
 * @date: 2020/09/18
 **/
public class Que1266 {
    /**
     * 因为题目说按顺序访问,所以可以判断两个点是长方形还是正方形
     * 时间复杂度 ： O(N)
     * 空间复杂度 ： O(1)
     *
     * @param points
     * @return
     */
    public int minTimeToVisitAllPoints(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int firstX = points[i][0];
            int firstY = points[i][1];
            int secondX = points[i + 1][0];
            int secondY = points[i + 1][1];

            int axisX = Math.abs(firstX - secondX);
            int axisY = Math.abs(firstY - secondY);

            //判断是长方形还是正方形
            if (axisX == axisY) {
                count += axisX;
            } else {
                count += axisX > axisY ? axisX : axisY;
            }
        }

        return count;

    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 1}, {3, 4}, {-1, 0}};
        System.out.println(new Que1266().minTimeToVisitAllPoints(arr));
    }
}
