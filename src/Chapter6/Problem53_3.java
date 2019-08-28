package Chapter6;/**
 * @author ZhouWu
 * @create 2019-08-27-16:34
 */

/**
 *@ClassName Problem53_3
 *@Description TODO:
 *@Version 1.0
 */
public class Problem53_3 {
    public static void main(String[] args) {
        int[] arr = {-3, -1, 1, 3, 5};
        System.out.println(getNumberSameAsIndex(arr));
    }

    private static int getNumberSameAsIndex(int[] arr) {
        if (arr.length == 0) return -1;
        int start = 0;
        int end = arr.length-1;

        while (start <= end) {
            int middle = (start+end) >> 1;
            if (arr[middle] == middle) return arr[middle];
            if (arr[middle] > middle) end = middle-1;
            else start = middle+1;
        }
        return -1;
    }

}
