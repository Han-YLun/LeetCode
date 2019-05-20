import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Han-YLun
 * @date 2019/5/3 0003
 * @Version 1.0
 */
public class Que1002 {

    public List<String> commonChars(String[] A) {

        //记录每个字符出现的情况
        int[] result = new int[26];
        //保存结果
        List<String> list = new ArrayList<String>();


        //将第一个字符串的字符出现情况保存在数组中
        for (char c : A[0].toCharArray()) {
            result [c - 'a'] ++;
        }

        for (int i = 1; i < A.length; i++) {
            int[] temp = new int[26];
            for (char c : A[i].toCharArray()) {
                temp[c - 'a'] ++;
            }

            //两个字符串求交集
            for (int j = 0; j < 26; j++) {
                if (temp[j] == 0 || result [j] == 0){
                    result[j] = 0;
                }else{
                    result [j] = Math.min(result[j],temp[j]);
                }

            }
        }


        //将结果转化为字符串保存在list集合中
        for (int i = 0; i < 26; i++) {
            if (result[i] > 0){
                for (int j = 0; j < result[i]; j++) {
                    list.add((char)('a'+i)+"");
                }
            }
        }


        return list;
    }
}
