package FreqDataStr.Sort;/**
 * @author ZhouWu
 * @create 2019-08-28-9:34
 */

import java.util.Arrays;

/**
 *@ClassName InsertSort
 *@Description TODO： 直接插入排序
 *@Version 1.0
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {1, -34, 3, 3, 1, 342, -8484, 62611, -84};
        solution(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void solution(int[] arr) {
        int i, j;
        int temp;
        for (i = 1; i <= arr.length-1; i++) {
            if (arr[i] < arr[i-1]) { // 将arr[i]插入有序表
                temp = arr[i];
                for (j = i-1; j >= 0; j--){
                    if (arr[j] > temp) arr[j+1] = arr[j];
                    else break;
                }
                arr[j+1] = temp;
            }
        }
    }
}
