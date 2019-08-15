package Chapter5;/**
 * @author ZhouWu
 * @create 2019-08-13-20:49
 */

import org.junit.Test;

import java.util.Arrays;

/**
 *@ClassName Problem40
 *@Description TODO
 *@Version 1.0
 */
public class Problem39 {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, 2, 1, 1, 3, 34, 1, 1, 1, 434, 40};
        int result = overHalfNum(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(result);
    }

    private static int overHalfNum(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("输入的参数有误");
        }

        if (arr.length == 1) return arr[0];

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
                index = partition(arr, low,hight );
            }
        }
        int result = arr[mid];
        return result;
    }

    /**
     * @Description: partition is TODO: 中位数查找算法
     * @param: [arr, low, hight]
     * @return: int
     */
    private static int partition(int[] arr, int low, int hight) {
        if (arr.length == 0 || low < 0 || hight >= arr.length || low > hight) return 0;

        int index = getRamdom(low, hight);
        qSwap(arr, index, hight);

        int small = low - 1;
        for (index = low; index < hight; ++index) {
            if (arr[index] < arr[hight]) {
                ++small;
                if (small != index) {
                    qSwap(arr, index, small);
                }
            }
        }
        ++small;
        qSwap(arr, small, hight);
        return small;
    }

    private static void qSwap(int[] arr, int index, int hight) {
        int temp = arr[index];
        arr[index] = arr[hight];
        arr[hight] = temp;
    }

    private static int getRamdom(int low, int hight) {
        return (int) (Math.random() * (hight - low + 1) + low);
    }
}
