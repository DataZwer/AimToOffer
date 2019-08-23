package Chapter5;/**
 * @author ZhouWu
 * @create 2019-08-21-15:30
 */

/**
 *@ClassName problem45
 *@Description TODO：重新定义运算， 用二分的思想解决
 *@Version 1.0
 */
public class problem45 {
    public static void main(String[] args) {
        int[] arr = {3,32,321};
        sort(arr, 0, arr.length-1);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }

    public static void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int index = partition(arr, low, high);
        sort(arr, low, index-1);
        sort(arr, index+1, high);
    }

    public static int partition(int[] arr, int low, int high) {
        int base = arr[low];

        while (low < high) {
            while (!isSmall(arr[high] + "", base+"") && low < high) {
                high--;
            }
            if(low < high){
                arr[low] = arr[high];
                low++;
            }
            while(isSmall(arr[low]+"", base+"") && low < high){
                low++;
            }
            if(low < high){
                arr[high] = arr[low];
                high--;
            }
        }
        arr[low] = base;
        return low;
    }

    /**
     * 重新定义了运算
     * 返回true:表示m应该排在n的前面 ;
     * 返回false:表示n应该排在m的前面
     */
    public static boolean isSmall(String m, String n) {
        String str1 = m + n;
        String str2 = n + m;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) < str2.charAt(i)) {
                return true;
            } else {
                if (str1.charAt(i) > str2.charAt(i))
                    return false;
            }
        }
        return true;
    }
}
