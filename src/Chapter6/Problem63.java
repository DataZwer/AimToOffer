package Chapter6;/**
 * @author ZhouWu
 * @create 2019-09-02-17:16
 */

/**
 *@ClassName Problem63
 *@Description TODO
 *@Version 1.0
 */
public class Problem63 {
    public static void main(String[] args) {
        int[] arr = {9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println(MaxDiff(arr));
    }

    private static int MaxDiff(int[] arr) {
        if (arr.length < 2) return 0;
        int min = arr[0];
        int maxDiff = arr[1] - min;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i-1] < min) min = arr[i-1];

            int currentDiff = arr[i] - min;
            if (currentDiff > maxDiff) maxDiff = currentDiff;
        }
        return maxDiff;
    }
}
