import java.util.ArrayList;
import java.util.List;

/**
 * @author: hyl
 * @date: 2019/08/05
 **/
public class Que22 {

    public List<String> generateParenthesis(int n) {

        List<String> resultList = new ArrayList<String>();

        generateString("",resultList,n,n);
        return resultList;
    }

    private void generateString(String s, List<String> resultList, int left, int right) {

        if (left == 0 && right == 0){
            resultList.add(s);
            return;
        }

        if (left > 0){
            generateString(s+"(",resultList, left - 1,right);
        }

        if (right > left){
            generateString(s + ")",resultList, left , right-1);
        }
        

    }
}
