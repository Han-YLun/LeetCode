/**
 * @author: hyl
 * @date: 2020/03/10
 **/
public class Que1342 {

    /**
     * 暴力迭代
     * 时间复杂度 ： O(logN)
     * 空间复杂度 : O(1)
     */
    public int numberOfSteps (int num) {
        //记录总的次数
        int count = 0;
        while (num != 0){
            //如果与1为0则为偶,否则为奇
            if ((num & 1) == 0){
                num >>= 1;
            }else{
                num &= -2;
            }
            count++;
        }
        return count;
    }


    /**
     * 递归
     * 时间复杂度 ： O(logN)
     * 空间复杂度 : O(1)
     */
    private int count = 0;
    public int numberOfSteps1 (int num) {
        if (num != 0){
            count++;
            //如果为偶,就除以2;否则减1
            if ((num & 1) != 0){
                //为奇,除以2
                numberOfSteps1(num >> 1);
            }else{
                //为偶,减1
                numberOfSteps1(num & -2);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(1 & -2);
    }
}
