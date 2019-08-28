package AlgorithmDesignAndAnalysis.Chapter1Recur;/**
 * @author ZhouWu
 * @create 2019-08-23-17:24
 */

/**
 *@ClassName BinarySearch
 *@Description TODO: 二分法
 *@Version 1.0
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2, 3, 4, 5, 6};
        int elem = 4;
        System.out.println(bsearch(arr, elem));
    }

    private static int bsearch(int[] arr, int elem) {
        int left = 0;
        int right = arr.length-1;
        while(left <= right) {
            int midle = (left+right) / 2;
            if (elem == arr[midle]) return midle;

            if (elem > arr[midle]) left = midle+1;
            else right = midle - 1;
        }
        return -1;
    }
}
