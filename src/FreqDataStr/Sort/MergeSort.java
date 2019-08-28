package FreqDataStr.Sort;/**
 * @author ZhouWu
 * @create 2019-08-28-10:38
 */

import java.util.Arrays;

/**
 *@ClassName MergeSort
 *@Description TODO
 *@Version 1.0
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {6, 8, 10, 9, 4, 5, 2, 7};
        int[] arr2 = {2, 8, 9, 10, 4, 5, 6, 7};

        merge(arr2, 0, 4, 7);
        System.out.println(Arrays.toString(arr2));
        System.out.println("#################################");
        solution(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    public static void solution(int[] arr, int L, int R) {
        if (L == R) return;
        int M = (L + R) >> 1;
        solution(arr, L, M);
        solution(arr, M+1, R);
        merge(arr, L, M+1, R);
    }


    private static void merge(int[] arr, int L, int M, int R) {
        int i, j, k;
        int leftSize = M - L;
        int rightSize = R - M + 1;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        // 拆分成排好序的两个部分
        for (i = L; i < M; i++) left[i-L] = arr[i];
        for (i = M; i <= R; i++) right[i - M] = arr[i];

        // 合并到原来的数组
        i = 0;
        j = 0;
        k = L;

        while(i < leftSize && j < rightSize) {
            if (left[i] < right[j]) arr[k++] = left[i++];
            else arr[k++] = right[j++];
        }
        while (i < leftSize) arr[k++] = left[i++];
        while (j < rightSize) arr[k++] = right[j++];
    }
}
