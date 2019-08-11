package Chapter2;

import java.util.Arrays;

public class QSTest {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, -34, 55, -344, 346634, 33, 4};
        int[] arr1 = new int[] {1};
        int[] arr2 = {};

        qSorted(arr, 0, arr.length-1);
        qSorted(arr1, 0, arr1.length-1);
        qSorted(arr2, 0, arr2.length-1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

    }

    public static void qSorted(int[] arr, int start, int end) {
        if (start == end) return;
        int index = partition(arr, start, end);
        if (index > start) qSorted(arr, start, index-1);
        if (index < end) qSorted(arr, index+1, end);

    }

    private static int partition(int[] arr, int start, int end) {
        if (arr.length == 0 || start < 0 || end >= arr.length || start > end) return 0;

        int index = getRamdom(start, end);
        qSwap(arr, index, end);

        int small = start - 1;
        for (index = start; index < end; ++index) {
            if (arr[index] < arr[end]) {
                ++small;
                if (small != index) {
                    qSwap(arr, index, small);
                }
            }
        }
        ++small;
        qSwap(arr, small, end); // 把天选换到中间
        return small;
    }

    private static void qSwap(int[] arr, int index, int small) {
        int temp = arr[index];
        arr[index] = arr[small];
        arr[small] = temp;
    }

    private static int getRamdom(int start, int end) {
        return (int) (Math.random() * (end - start + 1)) + start;
    }
}
