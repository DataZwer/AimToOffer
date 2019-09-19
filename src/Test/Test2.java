package Test;/**
 * @author ZhouWu
 * @create 2019-09-10-20:45
 */

/**
 *@ClassName Test2
 *@Description TODO: 手撕二分
 *@Version 1.0
 */
public class Test2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 9, 11};
        int[] arr2 = {2};
        int[] arr3 = {};
        System.out.println(solution(arr, 4));
        System.out.println(solution(arr2, 1));
        System.out.println(solution(arr3, 4));

    }

    private static boolean solution(int[] arr, int key) {
        return func(arr, key, 0, arr.length-1);
    }

    private static boolean func(int[] arr, int key, int start, int end) {
        if (arr.length == 0 || start > end) return false;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (arr[middle] > key) end = middle - 1;
            else if (arr[middle] < key) start = middle + 1;
            else return true;
        }
        return false;
    }

}
