import java.util.HashSet;

/**
 * @Author: Han-YLun
 * @date 2019/6/2 0002
 * @Version 1.0
 */
public class Que3 {

    public int lengthOfLongestSubstring(String s) {

        int left = 0, right = 0;
        int ans = 0;
        HashSet<Character> set = new HashSet<Character>();

        while (right < s.length()){
            if (!set.contains(s.charAt(right))){
                set.add(s.charAt(right++));
                ans = Math.max(ans,right-left);
            }else{
                set.remove(s.charAt(left++));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Que3 que3 = new Que3();
        que3.lengthOfLongestSubstring("abcabcbb");
    }
}
