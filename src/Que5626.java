/**
 * @author: hyl
 * @date: 2020/12/13
 **/
public class Que5626 {

    /**
     * 从字符串中找到最大的字符
     * 时间复杂度为O(N),空间复杂度为O(N)
     *
     * @param n
     * @return
     */
    public int minPartitions(String n) {

        char[] chars = n.toCharArray();
        char res = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (res < chars[i]) {
                res = chars[i];
            }
        }
        return res - 48;
    }
}
