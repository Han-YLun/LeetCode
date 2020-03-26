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
       //判断是否为空
       if (s == null || s.equals("")){
           return "";
       }

       int left , right , maxStart = 0 , maxLen = 0 , len = 1;
       int strLen = s.length();
       for (int i = 0; i < strLen; i++) {
           left = i - 1;
           right = i + 1;

           //当前的是否和左边的相等
           while (left >= 0 && s.charAt(left) == s.charAt(i)){
               len ++;
               left--;
           }

           //当前的是否和右边的相等
           while(right < strLen && s.charAt(right) == s.charAt(i)){
               len++;
               right++;
           }

           //左右两边的是否相等
           while (left >= 0 && right < strLen && s.charAt(left) == s.charAt(right)){
               len += 2;
               left--;
               right++;
           }

           //判断是否长度大于最大的长度
           if (len > maxLen){
               maxLen = len;
               maxStart = left;
           }
           len = 1;
           
       }
       return s.substring(maxStart +1, maxStart + maxLen+1);
    }

    public static void main(String[] args) {
        System.out.println(new Que5().longestPalindrome(""));
    }

}
