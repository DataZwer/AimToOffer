package Chapter6;/**
 * @author ZhouWu
 * @create 2019-09-02-16:08
 */

/**
 *@ClassName Problem60
 *@Description TODO:n个骰子的点数
 *@Version 1.0
 */
public class Problem60 {
    public static void main(String[] args) {
        int n = 5;
        printSum(n);
    }

    public static void printSum(int n) {
        int maxV = 6;

        if(n<1) {
            return ;
        }

        // 初始化数组
        int maxSum = maxV * n;
        int[] probList = new int[maxSum-n+1];

        // 递归计算骰子点数
        Probability(n,probList);

        // 计算基数
        int total = (int)Math.pow(maxV, n);

        // 打印比例
        for(int i=n;i<maxSum;i++) {
            System.out.printf("%d:%f\n",i,(double)probList[i-n]/total);
        }
    }


    // 分成两堆，循环是指当分为单独一个的骰子分别取1~6时，另外的一堆的各种取值
    public static void Probability(int n,int[] probList) {
        // 第一轮递归时，没有需要记录的sum，初始sum即为单独的骰子被设置为的数值
        for(int i=1;i<=6;i++) {
            Probability(n,n,i,probList);
        }
    }

    // sum为当前面的固定的和
    public static void Probability(int orig, int curr, int sum, int[] probList) {
        if(curr==1) {
            probList[sum-orig]++;
        }else {
            for(int i=1;i<=6;i++) {
                Probability(orig, curr-1, i+sum, probList);
            }
        }
    }
}
