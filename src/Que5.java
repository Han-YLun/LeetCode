/**
 * @author: hyl
 * @date: 2020/03/26
 **/
public class Que5 {


    /**
     * 求字符串中的最长回文子串
     *      中心扩散法
     *      时间复杂度： O(N * log(N))
     *      空间复杂度： O(1)
     * @param s 传入的字符串
     * @return  最长的回文子串
     */
    public String longestPalindrome(String s) {
       char[] str = s.toCharArray();
       //判断是否为空
       if (s == null || s.equals("")){
           return "";
       }

       int[] range = new int[2];
       int strLen = s.length();
       for (int i = 0; i < strLen; i++) {
           int left = i - 1;
           int right = i + 1;

           //当前的是否和左边的相等
           while (left >= 0 && str[left] == str[i]){
               left--;
           }

           //当前的是否和右边的相等
           while(right < strLen && str[right] == str[i]){
               right++;
           }

           //左右两边的是否相等
           while (left >= 0 && right < strLen && str[left] == str[right]){
               left--;
               right++;
           }

           //判断是否长度大于最大的长度
           if (right - left > range[1] - range[0]){
               range[0] = left;
               range[1] = right;
           }

       }
       return s.substring(range[0]+1, range[1]);
    }

    /**
     * 动态规划
     *      时间复杂度： O(N * N)
     *      空间复杂度： O(N*N)
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.equals("")){
            return "";
        }

        int len = s.length();
        int maxStart = 0;
        int maxLen = 1;

        char[] str = s.toCharArray();

        boolean[][] dp = new boolean[len][len];
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                if (str[l] == str[r] && (r - l <= 2 || dp[l+1][r-1])){
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen){
                        maxLen = r - l + 1;
                        maxStart = l;
                    }
                }
            }

        }


        return s.substring(maxStart , maxStart + maxLen);
    }





    public static void main(String[] args) {
        System.out.println(new Que5().longestPalindrome(""));
    }

}
