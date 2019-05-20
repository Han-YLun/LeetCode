import java.util.concurrent.ForkJoinPool;

/**
 * @Author: Han-YLun
 * @date 2019/5/4 0004
 * @Version 1.0
 */
public class Que985 {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] result = new int [queries.length];
        int resultI = 0;
        int changePre;
        int sum = 0;


        A[queries[0][1]] += queries[0][0];

        for (int i = 0; i < A.length; i++) {
            if (A [i] % 2 ==0){
                sum += A[i];
            }
        }
        result[resultI++] = sum;


        for (int i = 1; i < queries.length; i++) {

            changePre = A [queries [i][1]];
            A [queries [i][1]] += queries [i][0];

            if (changePre % 2 == 0){

                if (A [queries [i][1]] %2 == 0){
                    sum += A [queries [i][1]];
                }
                sum -= changePre;
           }else{
                if (A [queries [i][1]] % 2 == 0){
                    sum += A [queries [i][1]];
                }
            }

           result[resultI++] = sum;

        }
        return result;
    }

    public static void main(String[] args) {
        Que985 que985 = new Que985();

        que985.sumEvenAfterQueries(new int[]{3,2},new int[][]{{4,0},{3,0}});
    }
}
