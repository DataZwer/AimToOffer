package FreqDataStr.Sort;/**
 * @author ZhouWu
 * @create 2019-08-28-9:33
 */

import java.util.Arrays;

/**
 *@ClassName ShellSort
 *@Description TODO:
 *@Version 1.0
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {1, -34, 3, 3, 1, 342, -8484, 62611, -84};
        solution(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void solution(int[] a, int n) {
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // 共gap个组，对每一组都执行直接插入排序
            for (int i = 0 ;i < gap; i++) {
                for (int j = i + gap; j < n; j += gap) {
                    // 如果a[j] < a[j-gap]，则寻找a[j]位置，并将后面数据的位置都后移。
                    if (a[j] < a[j - gap]) {
                        int tmp = a[j];
                        int k = j - gap;
                        while (k >= 0 && a[k] > tmp) {
                            a[k + gap] = a[k];
                            k -= gap;
                        }
                        a[k + gap] = tmp;
                    }
                }
            }
        }
    }
}
