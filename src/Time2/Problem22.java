package Time2;/**
 * @author ZhouWu
 * @create 2019-09-28-10:15
 */

/**
 *@ClassName Problem19
 *@Description TODO
 *@Version 1.0
 */
public class Problem22 {

    public static void main(String[] args) {
        int[] arr = {3, 1};
        System.out.println(findMin(arr));
    }


    public static int findMin(int[] arr) {
        if (arr.length == 0) return -1;

        int start = 0;
        int end = arr.length-1;
        while (start < end) {
            int m = (start + end) >> 1;
            if (arr[m] > arr[start]) start = m;
            else if (arr[m] < arr[end]) end = m;
            else return find(arr);
        }
        return arr[start];
    }

    public static int find(int[] arr) {
        int res = arr[0];
        for (int i = 1; i < arr.length; i++)   if (arr[i] < res) res = arr[i];
        return res;
    }
}
