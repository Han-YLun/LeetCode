/**
 * @author: hyl
 * @date: 2020/09/26
 **/
public class Que1534 {

    /**
     * 暴力计算
     * 时间复杂度 ： O(N ^ 3)
     * 空间复杂度 ： O(1)
     *
     * @param arr
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        if (arr == null || arr.length == 0) {
            return 0;
        }


        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) > a){
                    continue;
                }
                for (int k = j + 1; k < arr.length; k++) {
                    if (Math.abs(arr[j] - arr[k]) <= b &&
                            Math.abs(arr[i] - arr[k]) <= c) {
                        count++;
                    }
                }
            }

        }
        return count;
    }

    /**
     * 通过减枝计算
     * 时间复杂度 ： O(N ^ 2)
     * 空间复杂度 ： O(N)
     * @param arr
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int countGoodTriplets1(int[] arr, int a, int b, int c) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int i = 0, j, k, index = -1, ans = 0;
        int[] list = new int[arr.length];
        while (i < arr.length-2){
            j = i + 1;
            while (j < (arr.length - 1) && Math.abs(arr[i] - arr[j]) > a){
                j++;
            }

            while (j < arr.length - 1){
                if (index < 0){
                    k = j +1;
                    while (k < arr.length){
                        if (Math.abs(arr[i] - arr[k]) <= c){
                            list[++index] = k;
                            if (Math.abs(arr[j] - arr[k]) <= b){
                                ans++;
                            }
                        }
                        k++;
                    }
                } else{
                    int t = 0;
                    while (t <= index && list[t] <= j){
                        t++;
                    }

                    while (t <= index){
                        if (Math.abs(arr[j] - arr[list[t]]) <= b){
                            ans++;
                        }
                        t++;
                    }
                }
                j++;
                while (j < (arr.length-1) && Math.abs(arr[i] - arr[j]) > a){
                    j++;
                }
            }
            index = -1;
            i++;
        }
        return ans;
    }

    /**
     * 使用前缀和的方式去求解
     * 时间复杂度：O(n^2+nS),其中n 是数组arr 的长度,S为数组的值域上限，这里为 10001000。
     *
     * 空间复杂度：O(S),我们需要 O(S)O(S) 的空间维护arr[i]频次数组的前缀和。
     * @param arr
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int countGoodTriplets2(int[] arr, int a, int b, int c) {
        int ans = 0, n = arr.length;
        int[] sum = new int[1001];
        for (int j = 0; j < n; ++j) {
            for (int k = j + 1 ; k < n; ++k) {
                if (Math.abs(arr[j] - arr[k]) <= b) {
                    int lj = arr[j] - a, rj = arr[j] + a;
                    int lk = arr[k] - c, rk = arr[k] + c;
                    int l = Math.max(0, Math.max(lj, lk)), r = Math.min(1000, Math.min(rj, rk));
                    if (l <= r) {
                        if (l == 0) {
                            ans += sum[r];
                        }
                        else {
                            ans += sum[r] - sum[l - 1];
                        }
                    }
                }
            }
            for (int k = arr[j]; k <= 1000; ++k) {
                ++sum[k];
            }
        }
        return ans;
    }

}
