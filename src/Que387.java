import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: hyl
 * @date: 2021/04/06
 **/
public class Que387 {

    /**
     * 使用HashMap存储频数,key为char,value为出现的次数
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0){
            return -1;
        }

        HashMap<Character,Integer> hashMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            hashMap.put(aChar,hashMap.getOrDefault(aChar,0)+1);
        }

        //查询在数组中的位置
        for (int i = 0; i < chars.length; i++) {
            if (hashMap.get(chars[i]) == 1){
                return i;
            }
        }
        return -1;
    }

    /**
     * 使用HashMap存储字符和出现的的位置,找出最小的且不为-1,即为第一个不重复字符的索引
     * @param s
     * @return
     */
    public int firstUniqChar1(String s) {
        if (s == null || s.length() == 0){
            return -1;
        }

        HashMap<Character,Integer> hashMap = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (hashMap.containsKey(c)){
                hashMap.put(c,-1);
            }else{
                hashMap.put(c , i);
            }

        }

        int first = n;
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            int pos = entry.getValue();
            if (entry.getValue() != -1 && first > pos){
                first = pos;
            }
        }

        if (first == n){
            return -1;
        }

        return first;
    }

    public static void main(String[] args) {
        System.out.println(new Que387().firstUniqChar1("aabb"));
    }


}
