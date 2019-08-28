package Chapter6;/**
 * @author ZhouWu
 * @create 2019-08-26-15:38
 */

/**
 *@ClassName Problem53
 *@Description TODO: 在排序数组中查找某个数字出现的个数(递归二分法)
 *@Version 1.0
 */
public class Problem53 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(GetFirstK(arr, 0, arr.length, 3));
        System.out.println(GetLastk(arr, 0, arr.length, 3));

    }

    // 求首位置
    private static int GetFirstK(int[] arr, int start, int end, int k) {
        if (start > end) return -1;
        int middleIndex = (start + end) / 2;
        int middleData = arr[middleIndex];
        if(middleData == k) {
            if((middleIndex > 0 && arr[middleIndex-1] != k) || middleIndex == 0) {
                return middleIndex;
            } else {
                end = middleIndex - 1;
            }
        } else if (middleData > k) {
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }
        return GetFirstK(arr, start, end, k);
    }

    // 求末位置
    private static int GetLastk(int[] arr, int start, int end, int k) {
        if (start > end) return -1;
        int middleIndex = (start + end) / 2;
        int middleData = arr[middleIndex];
        if(middleData == k) {
            if((middleIndex < arr.length-1 && arr[middleIndex+1] != k) || middleIndex == arr.length-1) {
                return middleIndex;
            } else {
                start = middleIndex + 1;
            }
        } else if (middleData < k) {
            start = middleIndex + 1;
        } else {
            end = middleIndex - 1;
        }
        return GetLastk(arr, start, end, k);
    }


}
