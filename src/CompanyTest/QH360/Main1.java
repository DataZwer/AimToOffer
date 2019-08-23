package CompanyTest.QH360;/**
 * @author ZhouWu
 * @create 2019-08-15-20:11
 */

import java.util.Scanner;

/**
 *@ClassName Main1
 *@Description TODO
 *@Version 1.0
 */
public class Main1 {
    public static int n;
    public static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] =  sc.nextInt();
                if (arr[i][j] < 0) System.exit(0);
            }
        }
        int result = func(arr, n, m);
        System.out.println(result);
    }

    private static int func(int[][] arr, int n, int m) {
        if (arr.length == 0) return 0;

        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                res += arrS(arr, i, j);
            }
        }
        return res;
    }

    // 返回该位置正方体贡献的面积
    private static int arrS(int[][] arr, int index_i, int index_j) {
        int count = 0; // 被挡的面
        if (arr[index_i][index_j] == 0) return 0;
        for (int i = 1; i <= arr[index_i][index_j]; i++) {
            count++;
            if (inarr(index_i, index_j-1) && i <= arr[index_i][index_j-1]) count++;
            if (inarr(index_i, index_j+1) && i <= arr[index_i][index_j+1]) count++;
            if (inarr(index_i-1, index_j) && i <= arr[index_i-1][index_j]) count++;
            if (inarr(index_i+1, index_j) && i <= arr[index_i+1][index_j]) count++;
        }

        if (arr[index_i][index_j] == 1) count--;
        return arr[index_i][index_j]*6 - count;
    }

    private static boolean inarr(int idx1, int idx2) {
        if (idx1 < 0 || idx1 >= n) return false;
        if (idx2 < 0 || idx2 >= m) return false;
        return true;
    }
}
