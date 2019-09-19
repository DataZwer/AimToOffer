package Test;/**
 * @author ZhouWu
 * @create 2019-09-19-8:43
 */

import static FreqDataStr.Sort.SlectionSort.swap;

/**
 *@ClassName Test3
 *@Description TODO
 *@Version 1.0
 */
public class Test3 {
    public static void main(String[] args) {
        int[] arr = {};
    }

    public static void qSort(int[] arr, int start, int end) {
        if (arr.length == 0 || start > end) return;
        int baseValue = arr[start];
        int i = end;
        int j = start;

        while (i < j) {
            while (i < j) if (arr[i--] < baseValue) break;
            if (i > j) {
                arr[i] = arr[j];
                j++;
            }
            while (j < i) if (arr[j++] > baseValue) break;
            if (i > j) {
                arr[j] = arr[i];
                i--;
            }
        }

        arr[j] = baseValue;


    }


}
