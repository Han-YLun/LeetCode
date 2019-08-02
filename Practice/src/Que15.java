import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.JarEntry;

/**
 * @author: hyl
 * @date: 2019/08/02
 **/
public class Que15 {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
           
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length - 2; i++) {



            for (int j = i + 1; j < nums.length - 1; j++) {

                for (int k = j + 1; k < nums.length; k++) {

                    while(i+1 < nums.length-2 && nums[i] == nums[i+1]){
                        i++;
                    }

                    while(j+1 < nums.length-1 && nums[j] == nums[j+1]){
                        j++;
                    }

                    while(k+1 < nums.length && nums[k] == nums[k+1]){
                        k++;
                    }

                    if (nums[i] + nums[j] + nums[k] == 0) {

                        List<Integer> list = new ArrayList<Integer>();

                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);

                        resultList.add(list);
                    }
                }


            }


        }
        return resultList;
    }

    public static void main(String[] args) {
        new Que15().threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}
