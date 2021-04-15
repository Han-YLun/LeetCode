/**
 * @author: hyl
 * @date: 2021/04/14
 **/
public class Que14 {

    /**
     * 横向扫描,一行一行去扫描
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }

        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            res = getLongestCommonPrefixByTwoString(res, strs[i]);
            if (res.length() == 0) {
                break;
            }
        }

        return res;


    }

    private String getLongestCommonPrefixByTwoString(String str1, String str2) {


        int len = Math.min(str1.length(), str2.length());

        int index = 0;
        while (index < len && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str2.substring(0, index);
    }

    /**
     * 纵向扫描
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }

        int len = strs[0].length();
        int count = strs.length;

        for (int i = 0; i < len; i++) {
            char c = strs[0].charAt(i);

            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    /**
     * 分治
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }

        return longestCommonPrefix(strs, 0, strs.length - 1);


    }

    private String longestCommonPrefix(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        } else {
            int mid = left + (right - left) / 2;
            String firstPre = longestCommonPrefix(strs, left,mid);
            String secondPre = longestCommonPrefix(strs, mid+1,right);
            return commonPrefix(firstPre,secondPre);
        }

    }

    private String commonPrefix(String firstPre, String secondPre) {
        int minLen = Math.min(firstPre.length(),secondPre.length());

        for (int i = 0; i < minLen; i++) {
            if (firstPre.charAt(i) != secondPre.charAt(i)){
                return firstPre.substring(0,i);
            }
        }
        return firstPre.substring(0,minLen);
    }

    /**
     * 二分查找
     * @param strs
     * @return
     */
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }

        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            if (minLength > str.length()){
                minLength = str.length();
            }
        }

        int left = 0, right = minLength;
        while (left < right){
            int mid = left + (right - left+1) / 2;
            if (isCommonPrefix(strs,mid)){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return strs[0].substring(0,left);


    }

    private boolean isCommonPrefix(String[] strs, int mid) {
        String str = strs[0].substring(0,mid);
        int count = strs.length;

        for (int i = 1; i < count; i++) {
            String tempStr = strs[i];
            for (int j = 0; j < mid; j++) {
                if (tempStr.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        String[] strs = new String[]{"ab","a"};
        System.out.println(new Que14().longestCommonPrefix3(strs));
    }
}
