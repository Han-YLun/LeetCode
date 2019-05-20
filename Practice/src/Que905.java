/**
 * @Author: Han-YLun
 * @date 2019/5/3 0003
 * @Version 1.0
 */
public class Que905 {

    public int[] sortArrayByParity(int[] A) {

        int[] arr = new int[A.length];
        int start = 0,
                end = A.length-1;
        for (int i = 0; i < A.length; i++) {
            if(A[i] % 2 == 0){
                arr[start++] = A[i];
            }else{
                arr[end--] = A[i];
            }
        }

        return arr;
    }
    public static void main(String[] args) {

    }
}
