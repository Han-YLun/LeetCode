/**
 * @Author: Han-YLun
 * @date 2019/5/3 0003
 * @Version 1.0
 */
public class Que922 {

    public int[] sortArrayByParityII(int[] A) {

        int[] arr1 = new int[A.length];
        int[] arr2 = new int[A.length];
        int arr1Index = 0,
                arr2Index = 1;
        for (int i = 0; i < A.length; i++) {
            if(A[i] % 2 == 0 ){
                arr1[arr1Index] = A [i];
                arr1Index += 2;
            }else{
                arr2[arr2Index] = A [i];
                arr2Index += 2;
            }
        }

        for (int i = 0; i < arr1.length; i++) {
            if(arr2[i] != 0){
                arr1[i] = arr2[i];
            }
        }



        return arr1;
    }
}
