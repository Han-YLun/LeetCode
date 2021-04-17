import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: hyl
 * @date: 2021/04/17
 **/
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    List<NestedInteger> getList();
}

public class Que341 {
    class NestedIterator implements Iterator<Integer> {

        private List<Integer> list;
        private Iterator<Integer> iterator;

        public NestedIterator(List<NestedInteger> nestedList) {
            list = new ArrayList<>();
            dfs(nestedList);
            iterator = list.iterator();
        }

        private void dfs(List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()){
                    list.add(nestedInteger.getInteger());
                }else{
                    dfs(nestedInteger.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
           return iterator.hasNext();
        }
    }
}
