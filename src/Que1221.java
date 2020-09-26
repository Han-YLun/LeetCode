/**
 * @author: hyl
 * @date: 2020/09/18
 **/
public class Que1221 {

    /**
     * 使用num记录为0即来回RL结果
     * 时间复杂度 ： O(N)
     * 空间复杂度 ： O(1)
     * @param s
     * @return
     */
    public int balancedStringSplit(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int num = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                num++;
            }else{
                num--;
            }

            if (num == 0){
                count++;
            }
        }
        return count;
    }

}
