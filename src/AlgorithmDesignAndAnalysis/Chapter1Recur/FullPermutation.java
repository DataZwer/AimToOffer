package AlgorithmDesignAndAnalysis.Chapter1Recur;/**
 * @author ZhouWu
 * @create 2019-08-23-16:40
 */

/**
 *@ClassName FullPermutation
 *@Description TODO：实现某个对象的全排列
 *@Version 1.0
 */


public class FullPermutation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;
        int m = arr.length-1;
        perm(arr, k, m);
    }

    private static void perm(int[] arr, int k, int m) {
        if (k == m) {
            for (int i = 0; i <= m; i++) System.out.print(arr[i] + " ");
            System.out.println();
        } else {
            for (int i = k; i <= m; i++) {
                swap(arr, k, i);
                perm(arr, k+1, m);
                swap(arr, k, i);
            }
        }
    }

    private static void swap(int[] arr, int k, int i) {
        int temp = arr[k];
        arr[k] = arr[i];
        arr[i] = temp;
    }


}
