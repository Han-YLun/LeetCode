import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: hyl
 * @date: 2019/08/03
 **/
public class Que18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> resultList = new ArrayList<List<Integer>>();

        if (nums.length < 4){
            return resultList;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {

            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            for (int j = i+1; j < nums.length-1; j++) {

                if (j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                int l = j + 1;
                int r = nums.length-1;

                while (l < r){
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];

                    if (sum < target){
                        l++;
                    }else if (sum > target){
                        r--;
                    }else{

                        List<Integer> list = new ArrayList<Integer>();

                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);

                        resultList.add(list);

                        while (l < r-1 && nums[l] == nums[l+1]){

                            l++;
                        }

                        while (r < nums.length-1 && nums[r] == nums[r+1]){
                            r--;
                        }

                        l++;
                        r--;
                    }


                }
                

            }
            
        }

        return resultList;
    }
}
