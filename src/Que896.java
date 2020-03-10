/**
 * @Author: Han-YLun
 * @date 2019/5/10 0010
 * @Version 1.0
 */
public class Que896 {

    public boolean isMonotonic(int[] A) {

       boolean sort = A [A.length -1] > A [0] ? true : false;

        for (int i = 0; i < A.length-1; i++) {
            if (sort == true && A [i] > A[i+1] || sort == false && A [i] < A[i+1]){
                return  false;
            }
        }
       
       return  true;
    }
}
