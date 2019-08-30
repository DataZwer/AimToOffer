package CompanyTest.Huawei;/**
 * @author ZhouWu
 * @create 2019-08-29-15:32
 */

import java.util.Scanner;

/**
 *@ClassName Test1Right
 *@Description TODO
 *@Version 1.0
 */
public class Test1Right {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n;
        while(sc.hasNext())
        {
            n=sc.nextInt();
            if (n <= 0) break;
            System.out.println(Drink(n));
        }

    }

    public static int Drink(int n)
    {
        if(n<=0)
            return 0;
        else if(n==3)
            return 1;
        else if(n==2)
            return 1;
        else//此时表明对应为3的倍数，递归
        {
            int h=0;
            h=n/3;
            return h+Drink(n-3*h+h);
        }


    }
}
