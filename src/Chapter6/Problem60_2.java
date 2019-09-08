package Chapter6;/**
 * @author ZhouWu
 * @create 2019-09-02-16:23
 */

/**
 *@ClassName Problem60_2
 *@Description TODO
 *@Version 1.0
 */
public class Problem60_2 {
    static int maxV = 6;

    public static void main(String[] args) {
        int n =3;
        printSum(n);
    }

    public static void printSum(int n) {
        if(n<1) {
            return;
        }

        int[][] prob = new int[2][maxV*n+1];
        int flag = 0;

        // 第一轮的初始化
        for(int i=1;i<=maxV;i++) {
            prob[flag][i] = 1;
        }

        // k是加入了几颗骰子
        for(int k=2;k<=n;k++) {
            System.out.printf("%d time\n",k);
            for(int i=1;i<=k;i++) {
                prob[1-flag][i]=0;
            }

            // i是当前更新的位置
            for(int i=k;i<=maxV*k;i++) {
                prob[1-flag][i]=0;
                // j是当前位置（和）的减去几 如n-1 n-2 n-3 n-4 n-5 n-6中的1~6
                for(int j=1;j<=i && j<=maxV;j++) {
                    if(i-j<=maxV*(k-1)) {  // 确认所加的数是上一轮的
                        prob[1-flag][i] += prob[flag][i-j];
                    }
                }
            }
            flag = 1-flag;
        }

        double sum=0;
        int total = (int)Math.pow(maxV, n);
        for(int i=n;i<prob[flag].length;i++) {
            sum+=(double)prob[flag][i]/total;
            System.out.printf("%d:%f\n",i,(double)prob[flag][i]/total);
        }
        System.out.println(sum);
    }
}

