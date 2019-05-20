import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Han-YLun
 * @date 2019/5/12 0012
 * @Version 1.0
 */
public class Que9 {

    public boolean isPalindrome(int x) {

        List<Integer> list = new ArrayList<Integer>();
        if (x < 0){
            return false;
        }

        while (x != 0){
            list.add(x %10);
            x /= 10;
        }

        int i =0,j = list.size()-1;
        while (i < j){
            if (list.get(i) != list.get(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }


}
