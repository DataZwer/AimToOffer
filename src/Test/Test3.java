package Test;/**
 * @author ZhouWu
 * @create 2019-09-19-8:43
 */


import java.util.Arrays;

/**
 *@ClassName Test3
 *@Description TODO
 *@Version 1.0
 */
public class Test3 {
    public static void main(String[] args) {
        int[] arr = {1, -2, 34, 8, 341, -345, 341};
        qSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    private static void qSort(int[] arr, int start, int end) {
        if (arr.length == 0 || start >= end) return;
        int i = start;
        int j = end;


    }


}
