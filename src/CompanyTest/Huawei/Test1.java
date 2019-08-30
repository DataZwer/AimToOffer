package CompanyTest.Huawei;/**
 * @author ZhouWu
 * @create 2019-08-29-14:22
 */

import java.util.Scanner;

/**
 *@ClassName Test1
 *@Description TODO
 *@Version 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int numberOfElem = 0;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            if (arr[i] >= 1 && arr[i] <= 100) {
                numberOfElem++;
            }
            else break;
        }
        solution(arr, numberOfElem);
    }

    public static void solution(int[] arr, int numberOfElem) {
        for (int i = 0; i < numberOfElem; i++) {
            int n = arr[i];
            int m1 = 0;
            int m2 = 0;
            int sum = 0;
            do {
                m1 = n / 3;
                m2 = n % 3;
                sum += m1;
                n = m1 + m2;
            } while (n >= 3);
            if (n == 2) sum += 1;
            System.out.println(sum+arr[i]);
        }
    }
}
