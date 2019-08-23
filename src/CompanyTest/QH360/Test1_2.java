package CompanyTest.QH360;/**
 * @author ZhouWu
 * @create 2019-08-15-16:26
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 *@ClassName Test2
 *@Description TODO
 *@Version 1.0
 */
public class Test1_2 {
    public static long Way(long x[],long y[]){
        Arrays.sort(x);
        Arrays.sort(y);
        if (x.length<2||y.length<2)
            return 0;
        long x_length=Math.abs(x[x.length-1]-x[0]);
        long y_length=Math.abs(y[y.length-1]-y[0]);
        return Math.max(x_length,y_length);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long X[]=new long[n];
        long Y[]=new long[n];
        for (int i = 0; i <n ; i++) {
            X[i]=sc.nextLong();
            Y[i]=sc.nextLong();
        }
        long res=Way(X,Y);
        System.out.println(res*res);
    }
}
