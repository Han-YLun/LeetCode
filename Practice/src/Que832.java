/**
 * @Author: Han-YLun
 * @date 2019/5/3 0003
 * @Version 1.0
 */
public class Que832 {

    public int[][] flipAndInvertImage(int[][] A) {

        for (int i = 0; i <A.length ; i++) {
            for (int j = A[i].length-1; j >=A[i].length/2 ; --j) {
                int temp =  A[i][A[i].length-1 - j];
                A[i][A[i].length-1 - j] = A[i][j];
                A[i][j] = temp;

            }

            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 0){
                    A[i][j] = 1;
                }else{
                    A[i][j] = 0;
                }
            }
        }

        return A;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,1,0},{1,0,1},{0,0,0}};
        Que832 a = new Que832();
        a.flipAndInvertImage(arr);
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "    ");
            }
            System.out.println();
        }
        
    }
}
