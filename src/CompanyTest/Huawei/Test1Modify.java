package CompanyTest.Huawei;/**
 * @author ZhouWu
 * @create 2019-08-29-15:36
 */

import java.util.Scanner;

/**
 *@ClassName Test1Modify
 *@Description TODO
 *@Version 1.0
 */
public class Test1Modify {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        while(sc.hasNext())
        {
            if ((n = sc.nextInt()) >= 1) solution(n);
            else break;
        }
    }

    public static void solution(int n) {
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
        System.out.println(sum);
    }
}
