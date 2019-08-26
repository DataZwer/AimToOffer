package Chapter5;/**
 * @author ZhouWu
 * @create 2019-08-23-15:16
 */

/**
 *@ClassName Problem47
 *@Description TODO
 *@Version 1.0

 */
public class Problem47 {
    public static void main(String[] args) {
        int[][] arr = { { 1, 10, 3, 8 }, { 12, 2, 9, 6 }, { 5, 7, 4, 11 },
                { 3, 7, 16, 5 } };
        System.out.println(getMaxValue(arr));
    }

    private static int getMaxValue(int[][] arr) {
        if (arr == null || arr.length == 0) return 0;

        int rows = arr.length;
        int cols = arr[0].length;

        int [] maxValue = new int[cols]; // 辅助数组
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                if (i > 0) {
                    up = maxValue[j];
                }
                if (j > 0) {
                    left = maxValue[j - 1];
                }
                maxValue[j] = Math.max(up, left) + arr[i][j];
            }
        }
        return maxValue[cols-1];
    }
}