/**
 * @author: hyl
 * @date: 2021/03/29
 **/
public class Que38 {

    /**
     * 使用循环计算
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        StringBuilder result = new StringBuilder();
        if(n <= 0){
            return result.toString();
        }


        result.append("1");
        for (int i = 1; i < n; i++) {

            StringBuilder tempSb = new StringBuilder();
            int start = 0;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) != result.charAt(start)){
                    tempSb.append(j-start).append(result.charAt(start));
                    start = j;
                }
            }
            tempSb.append(result.length()-start).append(result.charAt(start));
            result = tempSb;
        }

        return result.toString();

    }
}
