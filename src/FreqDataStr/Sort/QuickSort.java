package FreqDataStr.Sort;/**
 * @author ZhouWu
 * @create 2019-08-28-10:28
 */

import java.util.Arrays;

/**
 *@ClassName QuickSort
 *@Description TODO: 一趟快排和
 *@Version 1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, -34, 3, 3, 1, 342, -8484, 62611, -84};
//        solution1(arr, 0, arr.length-1);
//        System.out.println(Arrays.toString(arr));

        solution2(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    // 一趟快排
    public static void solution1(int[] arr, int start, int end) {
        if (arr.length == 0 || start >= end) return;
        int i = start;
        int j = end;
        int baseVal = arr[start];
        while (i < j) {
            while (i < j && arr[j] >= baseVal) j--;
            if (i < j) arr[i++] = arr[j];
            while(i < j && arr[i] < baseVal) i++;
            if(i < j) arr[j--] = arr[i];
            arr[i] = baseVal;
            solution1(arr, start, i-1);
            solution1(arr, i+1, end);
        }
    }

    public static void solution2(int[] arr, int start, int end) {
        if (arr.length == 0 ||start >= end) return;
        int index = partition(arr, start, end);
        if (index > start) solution2(arr, start, index-1);
        else solution2(arr, index+1, end);
    }

    public static int partition(int[] arr, int start, int end) {
        int index = getRandom(start, end);
        qSwap(arr, index, end);

        int small = start-1;
        for (index = start; index < end; index++) {
            if (arr[index] < arr[end]) {
                small++;
                if (small != end) qSwap(arr, index, small);
            }
        }
        ++small;
        qSwap(arr, small, end);
        return small;
    }

    public static int getRandom(int start, int end) {
        int num = (int) (Math.random() * (end - start + 1) + start); return num;
    }

    private static void qSwap(int[] arr, int index, int end) {
        int temp = arr[index]; arr[index] = arr[end]; arr[end] = temp;
    }

}