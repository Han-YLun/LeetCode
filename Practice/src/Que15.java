import java.lang.reflect.Array;
import java.util.*;
import java.util.jar.JarEntry;

/**
 * @author: hyl
 * @date: 2019/08/02
 **/
public class Que15 {

    //暴力(O（N^3）)
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
              
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length - 2; i++) {

            //判断当前是否和前一个数相等,可以进行去重
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }


            for (int j = i + 1; j < nums.length - 1; j++) {

                //判断当前是否和前一个数相等,可以进行去重
                if (j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                for (int k = j + 1; k < nums.length; k++) {

                    //判断当前是否和前一个数相等,可以进行去重
                    if (k > j+1 && nums[k] == nums[k-1]){
                        continue;
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

    /**
     * 使用两个for循环，一个map查询
     * 时间复杂度O（N^2）
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if (nums.length < 3){
            return resultList;
        }

        Arrays.sort(nums);
        Map<Integer,Integer> map = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }

        for (int i = 0; i < nums.length-2; i++) {


            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            for (int j = i+1; j < nums.length-1; j++) {

                if (j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }


                int sum = -(nums[i] + nums[j]);

                if (map.containsKey(sum) && map.get(sum) > j){
                    List<Integer> list = new ArrayList<Integer>();

                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(sum);

                    resultList.add(list);
                }

            }
        }

        return resultList;
    }


    /**
     * 使用一个for循环，两个指针从剩下的数两端逼近
     * 时间复杂度O（NlogN）
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if (nums.length < 3){
            return resultList;
        }

        //对数组进行排序
        Arrays.sort(nums);
        Map<Integer,Integer> map = new HashMap<>();


        //将数组放入map中,并将索引放入value中
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }

        for (int i = 0; i < nums.length-2; i++) {


            //进行判重处理
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int l = i + 1;
            int r = nums.length-1;


            while (l < r){

                int sum = nums[i] + nums[l] + nums[r];

                if (sum < 0){
                    l++;    //如果小于0,则向右逼近
                }else if (sum > 0){
                    r--;    //如果打于0,则向左逼近
                }else{
                    List<Integer> list = new ArrayList<Integer>();

                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);


                    resultList.add(list);

                    //在添加完成之后,在此进行判重处理
                    while (l+1 < r && nums[l] == nums[l+1]){
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

        return resultList;
    }

    public static void main(String[] args) {
        new Que15().threeSum(new int[]{-1,0,1,2,-1,-4});

    }
}
