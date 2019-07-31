import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.scenario.effect.impl.HeapImage;

import java.awt.event.KeyAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: hyl
 * @date: 2019/07/30
 **/
public class Que703 {

    //数组维护前K大的元素
    static class KthLargest {

        private List<Integer> list;
        private int indexK;
        private CompareOp compareOp = new CompareOp();
        
        public KthLargest(int k, int[] nums) {


            list = new ArrayList<Integer>(k);
            indexK = k;

            if (nums.length > 0){

                Arrays.sort(nums);

                if (indexK > nums.length){
                    int num = nums.length - 1;
                    while (num >= 0){
                        list.add(nums[num--]);
                    }
                } else{
                    int num = nums.length -1 ;

                    int i = 0;
                    while (i++ < indexK){
                        list.add(nums[num--]);
                    }

                }
            }

           list.sort(compareOp);
        }

        public int add(int val) {

            if (indexK > list.size()){
                list.add(val);
            }else{
                if (val > list.get(indexK-1)){
                    list.remove(list.size()-1);
                    list.add(val);
                }
            }

            list.sort(compareOp);

            return  list.get(indexK-1);
        }
    }

    //实用小顶堆维护前K大的元素
    static class KthLargest1{

        private int[] heap;
        private int count;
        private int len;

        public KthLargest1(int k, int[] nums) {

            heap = new int[k];
            len = k;
            count = 0;
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {

            if (count < len){
                heap[count++] = val;
                //shiftUp(count-1);
            }else if(val > heap[0]){
                heap[0] = val;
                //shiftDown();
            }
           return 0;
        }

    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3,new int[]{4,5,8,2});

        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }

    static class CompareOp implements Comparator{
        @Override
        public int compare(Object o1, Object o2) {
            return (Integer)o2 - (Integer)o1;
        }
    }

}



