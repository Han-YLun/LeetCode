/**
 * @author: hyl
 * @date: 2021/03/29
 **/
public class Que38 {

    /**
     * 使用循环计算
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        StringBuilder result = new StringBuilder();
        if (n <= 0) {
            return result.toString();
        }


        result.append("1");
        for (int i = 1; i < n; i++) {

            StringBuilder tempSb = new StringBuilder();
            int start = 0;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) != result.charAt(start)) {
                    tempSb.append(j - start).append(result.charAt(start));
                    start = j;
                }
            }
            tempSb.append(result.length() - start).append(result.charAt(start));
            result = tempSb;
        }

        return result.toString();

    }


    /**
     * 使用递归
     *
     * @param n
     * @return
     */
    public String countAndSay1(int n) {
        //递归终止条件
        if (n == 1) {
            return "1";
        }

        //获取到上一层的数
        String s = countAndSay1(n - 1);
        StringBuilder result = new StringBuilder();
        int start = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(start)){

                result.append(i-start).append(s.charAt(i));
                start = i;
            }
        }

        //字符串最后一个数字
        result.append(s.length()-start).append(s.charAt(start));
        return result.toString();
    }


}
