package chapter3;
/**
 * @author ZhouWu
 * @create 2019-07-26-14:42
 */

import java.util.Arrays;

/**
 *@ClassName Problem21
 *@Description TODO
 *@Version 1.0
 */
public class Problem21 {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 4, 53, 34, 53, -3, 3, 98, 0, 103};
        ReorderOddEven(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void ReorderOddEven(int[] arr) {
        if (arr.length == 0) return;
        int p_s = 0;
        int p_e = arr.length-1;
        while (p_s < p_e) {
            while (arr[p_s]%2 != 0) ++p_s;
            while (arr[p_e]%2 == 0) --p_e;
            if (p_s < p_e) {
                int tmp = arr[p_s];
                arr[p_s] = arr[p_e];
                arr[p_e] = tmp;
            }
        }
    }
}
