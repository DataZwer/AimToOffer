package CompanyTest.PDD;/**
 * @author ZhouWu
 * @create 2019-08-11-16:00
 */

import java.util.Scanner;

/**
 *@ClassName Main2
 *@Description TODO
 *@Version 1.0
 */
public class Main2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int L = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) arr[i] = scanner.nextInt();
        int res = solution(arr, L);
        System.out.println(res);
    }

    private static int solution(int[] arr, int L) {
        int sum1_1 = 0, sum2_1 = 0;
        int sum1_2 = 0, sum2_2 = 0;
        int sum1 = 0, sum2 = 0;
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                sum1_1 += (arr[j] - j);
                sum2_1 += (arr[i] - arr[j] - (i-j+1)) + 1;
            }

            for (int k = i+1; k < arr.length; k++) {
                sum1_2 = (L  - arr[k] - 1) + (arr.length-k);
                sum2_2 = (arr[k] - arr[i] - 1) - (k-i-1);
            }
            sum1 = sum1_1 + sum1_2;
            sum2 = sum2_1 + sum2_2;
            min = sum1 < sum1_2 ? sum1 : sum2;
        }
        return min;
    }
}
