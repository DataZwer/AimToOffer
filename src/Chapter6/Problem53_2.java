package Chapter6;/**
 * @author ZhouWu
 * @create 2019-08-26-16:04
 */

/**
 *@ClassName Problem53_2
 *@Description TODO: 0-1当中缺失的数字
 *@Version 1.0
 */
public class Problem53_2 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4, 5};
        System.out.println(findNumber(arr, 0, arr.length-1));
    }

    private static int findNumber(int[] arr, int start, int end) {
        if (arr.length == 0 || start > end) return -1;

        while (end >= start) {
            int middle = (start + end) >> 1;
            if (arr[middle] != middle) {
                if (middle == 0 || arr[middle-1] == middle-1) return middle;
                end = middle-1;
            } else {
                start = middle + 1;
            }
            if (start == end) return arr.length;
        }
        return -1;
    }


}
