/**
 * @author: hyl
 * @date: 2021/03/27
 **/
public class Que171 {
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        if (columnTitle == null || columnTitle.length() == 0){
            return sum;
        }

        char[] chars = columnTitle.toCharArray();
        for (char aChar : chars) {
            sum *= 10;
            sum += (aChar - 64);
        }
        return sum;
    }
}
