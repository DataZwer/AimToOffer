package CompanyTest.SXF;/**
 * @author ZhouWu
 * @create 2019-09-16-11:57
 */

import java.util.Scanner;

/**
 *@ClassName Test2
 *@Description TODO
 *@Version 1.0
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        int[] colorNum = new int[k];
        for (int i = 0; i < k; i++) colorNum[i] = scanner.nextInt();
        solotion(k, n, colorNum);
    }

    private static void solotion(int k, int n, int[] colorNum) {
        if (colorNum.length == 0) return;
        int cSum = 0;
        for (int i = 0; i < colorNum.length; i++) cSum += colorNum[i];
        if (cSum < n) return;

        int[] num = new int[k];
        int index = 0;
        func(index, num, colorNum, k, n, 0);
    }

    private static void func(int index, int[] num, int[] colorNum, int k, int n, int c) {

        if (index == k) {
            if (sum(num, index) == n) print(num, index);
            return;
        }
        if (sum(num, index) > n) return;  // 防止复杂度过大

        for (int j = 0; j <= colorNum[c]; j++) {
            num[index] = j;
            index++;
            func(index, num, colorNum, k, n, c+1);
            index--;
        }
    }

    private static void print(int[] num, int index) {
        for (int i = 0; i < index; i++) {
            System.out.print(num[i]);
        }
        System.out.println();
    }

    private static int sum(int[] num, int index) {
        int res = 0;
        for (int i = 0; i < index; i++) res += num[i];
        return res;
    }
}
