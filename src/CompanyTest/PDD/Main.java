package CompanyTest.PDD;/**
 * @author ZhouWu
 * @create 2019-08-11-15:17
 */

import org.junit.Test;

import java.util.Scanner;

/**
 *@ClassName Main
 *@Description TODO
 *@Version 1.0
 */
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) arr[i] = in.nextInt();
        double minRes = Double.MIN_VALUE;
        double res = solution(arr, minRes);
        System.out.println(res);
    }

    private static double solution(int[] arr, double minRes) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            for (int j = 0; j < arr.length && j != i; j++) {
                System.out.print(arr[j] + " ");
                for (int k = 0; k < arr.length && k != j; k++) {
                    System.out.println(arr[k]);
                }
            }
        }
        return 0;
    }


    @Test
    public void test1() {
        int arr[] = new int[] {1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            for (int j = 0; j < arr.length ; j++) {
                if (j != i)  System.out.print(arr[j] + " ");
                for (int k = 0; k < arr.length; k++) {
                    if (j != i && k != j)  System.out.print(arr[k] + " ");
                }
            }
            System.out.println();
        }
    }
}
