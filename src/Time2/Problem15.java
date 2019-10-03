package Time2;/**
 * @author ZhouWu
 * @create 2019-09-27-21:14
 */

/**
 *@ClassName Problem15
 *@Description TODO: 二维数组中的查找
 *@Version 1.0
 */
public class Problem15 {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 8, 10, 13},
                {6, 8, 11, 15}
        };

        System.out.println(searchArray(arr, 7));
    }

    static public boolean searchArray(int[][] arr, int target) {
        if (arr.length == 0) return false;
        int i = 0;
        int j = arr[0].length-1;
        while (i >= 0 && i < arr.length && j < arr[0].length && j >= 0) {
            if (arr[i][j] == target) return true;
            else if (arr[i][j] > target) j--;
            else i++;

        }
        return false;
    }




}
