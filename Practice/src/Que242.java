import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: hyl
 * @date: 2019/08/02
 **/
public class Que242 {

    public boolean isAnagram(String s, String t) {

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(s.toCharArray());
        Arrays.sort(t.toCharArray());

        return Arrays.toString(sArray).equals(Arrays.toString(tArray));

    }

    public boolean isAnagram1(String s, String t) {


        Map<Character,Integer> sMap = new TreeMap<Character, Integer>();
        Map<Character,Integer> tMap = new TreeMap<Character, Integer>();

        for (char c : s.toCharArray()) {
            sMap.put(c,sMap.getOrDefault(c,0)+1);
        }

        for (char c : t.toCharArray()) {
            tMap.put(c,tMap.getOrDefault(c,0)+1);
        }

        return sMap.entrySet().equals(tMap.entrySet());

    }

    public static void main(String[] args) {
        new Que242().isAnagram1("ab","a") ;
    }

}
