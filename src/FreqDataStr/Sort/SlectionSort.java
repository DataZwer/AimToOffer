package FreqDataStr.Sort;/**
 * @author ZhouWu
 * @create 2019-08-28-10:23
 */

import java.util.Arrays;

/**
 *@ClassName SlectionSort
 *@Description TODO
 *@Version 1.0
 */
public class SlectionSort {
    public static void main(String[] args) {
        int[] arr = {1, -34, 3, 3, 1, 342, -8484, 62611, -84};
        solution(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void solution(int[] arr) {
        for(int i = 0; i < arr.length-1; i++){
            int min = i;
            for(int j = i+1; j <= arr.length-1; j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            if(min!=i){
                swap(arr, i, min);
            }
        }
    }

    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
