/**
 * @author: hyl
 * @date: 2021/03/27
 **/
public class Que171 {

    /**
     * 26进制
     * @param columnTitle
     * @return
     */
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        if (columnTitle == null || columnTitle.length() == 0){
            return sum;
        }

        char[] chars = columnTitle.toCharArray();
        for (char aChar : chars) {
            sum *= 26;
            sum += (aChar - 'A') + 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Que171().titleToNumber("ZY"));
    }
}
