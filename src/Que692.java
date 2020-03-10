import java.util.*;

/**
 * @author: hyl
 * @date: 2019/08/02
 **/
public class Que692 {


    public List<String> topKFrequent(String[] words, int k) {

        Map<String,Integer> maps = new TreeMap<String, Integer>();

        List<String> resultList = new ArrayList<String>();


        for (String s : words) {
            maps.put(s, maps.getOrDefault(s,0)+1);
        }


        List<Map.Entry<String,Integer>> list = new ArrayList<>(maps.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });


        for (int i = 0; i < k; i++) {
            Map.Entry<String, Integer> result = list.get(i);

            resultList.add(result.getKey());
        }
        return resultList;
    }

    public static void main(String[] args) {
        new Que692().topKFrequent(
                new String[]{"i", "love", "leetcode", "i", "love", "coding"}
                ,2);
    }




}
