/**
 * @author: hyl
 * @date: 2020/09/18
 **/
public class Que1528 {

    /**
     * 直接暴力遍历即可
     * 时间复杂度 ： O(N)
     * 空间复杂度 ： O(N)
     *
     * @param s
     * @param indices
     * @return
     */
    public String restoreString(String s, int[] indices) {
        if (s == null || s.length() == 0 || indices == null || indices.length == 0) {
            return "";
        }

        char[] resCharArr = new char[s.length()];

        for (int i = 0; i < indices.length; i++) {
            resCharArr[indices[i]] = s.charAt(i);
        }
        return new String(resCharArr);
    }

    /**
     * 使用原地修改的方式达到空间复杂度O(1)
     * 时间复杂度 ： O(N)
     * 空间复杂度 ： O(1)
     *
     * @param s
     * @param indices
     * @return
     */
    public String restoreString2(String s, int[] indices) {
        if (s == null || s.length() == 0 || indices == null || indices.length == 0) {
            return "";
        }

        int len =s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            if (indices[i] != i){
                char ch = chars[i];
                int idx = indices[i];
                while (idx != i){
                    char temp = chars[idx];
                    chars[idx] = ch;
                    ch = temp;

                    int t = indices[idx];
                    indices[idx] = idx;
                    idx = t;

                }
                chars[i] = ch;
                indices[i] = i;
            }
        }

        return new String(chars);
    }
}
