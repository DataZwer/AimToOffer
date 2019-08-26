package Chapter5;/**
 * @author ZhouWu
 * @create 2019-08-24-16:00
 */

/**
 *@ClassName Problem49
 *@Description TODO: 丑数
 *@Version 1.0
 */
public class Problem49 {
    public static void main(String[] args) {
        System.out.print(amethod(1500));
    }

    public static int amethod(int x) {
        if(x<1)
            return 0;

        if(x==1)
            return 1;
        int[] list = new int[x];
        list[0]=1;
        int count = 1;
        int m2loc = 0;
        int m3loc = 0;
        int m5loc = 0;
        while(count<x) {
            list[count] = min(list[m2loc]*2,list[m3loc]*3,list[m5loc]*5);

            while(list[m2loc]*2<=list[count])
                m2loc++;

            while(list[m3loc]*3<=list[count])
                m3loc++;

            while(list[m5loc]*5<=list[count])
                m5loc++;

            System.out.printf("count:%d\t%d\n",count,list[count]);
            count++;
        }
        return list[x-1];
    }

    public static int min(int a,int b,int c) {
        int temp =  (b<c)?b:c;
        int re = (temp<a)?temp:a;
        return re;
    }
}
