package Chapter2;

import java.util.Arrays;

public class QSTest {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, -34, 55, -344, 346634, 33, 4};
        int[] arr_t = new int[] {1, 1, 2, 1, 1, 3, 34, 1, 1, 1, 434, 40};
        int[] arr1 = new int[] {1};

        int[] arr2 = {};



//        qSorted_1(arr, 0, arr.length-1);
//        qSorted_1(arr1, 0, arr1.length-1);
//        qSorted_1(arr2, 0, arr2.length-1);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(arr1));
//        System.out.println(Arrays.toString(arr2));

        qSorted_2(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void qSorted_1(int[] arr, int start, int end) { 
        if (start == end) return;
        int index = partition(arr, start, end);
        if (index > start) qSorted_1(arr, start, index-1);
        if (index < end) qSorted_1(arr, index+1, end);

    }

    /**
     * @Description:  is TODO: 中位数查找算法
     * @param: 
     * @return: 
     */
    public static void qSorted_2(int[] arr) {
        int mid = arr.length >> 1;
        int low = 0;
        int hight = arr.length - 1;
        int index = partition(arr, low, hight);
        while (index != mid) {
            if (index >  mid) {
                hight = index - 1;
                index = partition(arr, low, hight);
            } else {
                low = index + 1;
                index = partition(arr, low, hight);
            }
        }
    }

    /**
     * @Description: partition is TODO: ，移动到
     * @param: [arr, start, end]
     * @return: int
     */
    private static int partition(int[] arr, int start, int end) {
        if (arr.length == 0 || start < 0 || end >= arr.length || start > end) return 0;

        int index = getRamdom(start, end);  // 随机选择数组中的一个数
        qSwap(arr, index, end); // 移动到end的位置

        int small = start - 1;  // 计数功能
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
