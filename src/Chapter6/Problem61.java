package Chapter6;/**
 * @author ZhouWu
 * @create 2019-09-02-16:41
 */

import java.util.Arrays;

/**
 *@ClassName Problem61
 *@Description TODO
 *@Version 1.0
 */
public class Problem61 {
    public static void main(String[] args) {
        int[] a = new int[] {0, 1, 2, 3, 5};
        System.out.print(IsCont(a));
    }

    public static boolean IsCont(int[] a) {
        if(a==null || a.length==0) {
            return false;
        }
        // 排序
        Arrays.sort(a);

        // 0的个数和需要填补的数的个数
        int zero = zeroNum(a);
        int gap = gapNum(a,zero);

        // gap==-1表示有重复的数
        if(gap==-1) {
            return false;
        }
        // 根据两者的个数来判断
        if(gap<=zero) {
            return true;
        }else {
            return false;
        }
    }

    // 数组中0的个数
    public static int zeroNum(int[] a) {
        int m = 0;
        for(int i=0;i<a.length;i++) {
            if(a[i]==0) {
                m++;
            }else {
                return m;
            }
        }
        return m;
    }

    // 填补数的个数
    public static int gapNum(int[] a,int zero) {
        int sum = 0;
        for(int i=zero;i<a.length-1;i++) {
            if(a[i]==a[i+1]) {
                return -1;
            }
            if(a[i]+1!=a[i+1]) {
                sum = sum+a[i+1]-a[i]-1;
            }
        }
        return sum;
    }
}
