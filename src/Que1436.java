import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author: hyl
 * @date: 2020/05/21
 **/
public class Que1436 {
    /**
     * 将每段的终点放进set，如果不是最后的终点，每段的终点必是其他的起点
     * @param paths
     * @return
     */
    public String destCity(List<List<String>> paths) {
        if (paths == null || paths.size() == 0){
            return null;
        }
        HashSet set = new HashSet();
        for (List<String> path : paths) {
            set.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!set.contains(path.get(1))){
                return path.get(1);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        
        List<String> tempList = new ArrayList<>();
        tempList.add("ZrkzUqobDv");
        tempList.add("TINDTEETTv");
        list.add(tempList);

        tempList = new ArrayList<>();
        tempList.add("OozshcOhpB");
        tempList.add("ZrkzUqobDv");
        list.add(tempList);

        tempList = new ArrayList<>();
        tempList.add("RptSdsUfeH");
        tempList.add("BTYVayMQGQ");
        list.add(tempList);

        tempList = new ArrayList<>();
        tempList.add("ugNmb BOBZ");
        tempList.add("JCuKctgrbi");
        list.add(tempList);

        tempList = new ArrayList<>();
        tempList.add("JCuKctgrbi");
        tempList.add("OozshcOhpB");
        list.add(tempList);

        tempList = new ArrayList<>();
        tempList.add("BTYVayMQGQ");
        tempList.add("ugNmb BOBZ");
        list.add(tempList);

        System.out.println(new Que1436().destCity(list));

    }
}
