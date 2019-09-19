package Test;

import java.util.Arrays;


public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 10, -3, 34134, 19, 8577, 34, 94};
        int[] arr2 = {};
        int[] arr3 = {1};
        int[] arr4 = {21, 2};

        int start = 0;
        int end = arr.length - 1;
        solution1(arr, start, end);
        System.out.println(Arrays.toString(arr));

        start = 0;
        end = arr2.length - 1;
        solution1(arr2, start, end);
        System.out.println(Arrays.toString(arr2));

        start = 0;
        end = arr3.length - 1;
        solution1(arr3, start, end);
        System.out.println(Arrays.toString(arr3));

        start = 0;
        end = arr4.length - 1;
        solution1(arr4, start, end);
        System.out.println(Arrays.toString(arr4));
    }


    public static void solution1(int[] arr, int start, int end) {
        if (arr.length == 0 || start > end) return;
        int index = partition(arr, start, end);
        if (index > start) solution1(arr, start, index-1);
        else solution1(arr, index+1, end);
    }


    private static int partition(int[] arr, int start, int end) {

        int index = getRamdom(start, end); // 天选之子
        swap(arr, index, end);
        int small = start - 1;
        for (index = start; index < end; index++) {
            if (arr[index] < arr[end]) {
                small++;
                if (small != end)swap(arr, small, index);
            }
        }
        ++small;
        swap(arr, small, end);
        return small;
    }

    private static int getRamdom(int start, int end) {
        int num =  (int ) (Math.random() * (end - start + 1) + start);
        return num;
    }

    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    
}
