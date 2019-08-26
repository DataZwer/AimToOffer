package AlgorithmDesignAndAnalysis.DynamicProgramming;/**
 * @author ZhouWu
 * @create 2019-08-24-19:06
 */

/**
 *@ClassName Test1
 *@Description TODO: 输入一行数字， 选择1个或者多个数使得和最大，要求选出的数不能相邻
 *@Version 1.0
 */
public class Test1 {

    public static void main(String[] args) {
        int[] arr = {4, 1, 1, 9, 1};
        int n = 6;
        System.out.println(solution(arr,arr.length-1));

        int[] arr2 = {4, 1, 1, 9, 1};
        System.out.println(solotion_2(arr2));
    }

    // 用递归地方法来做了
    private static int solution(int[] arr, int n) {
        if (n == 0) return 0;
        else if (n == 1) {
            return Math.max(arr[0], arr[1]);
        } else {
            int a = solution(arr, n-2) + arr[n]; // 选
            int b = solution(arr, n-1); //不选
            return Math.max(a, b);
        }
    }

    private static int solotion_2(int[] arr) {
        int [] opt = new int[arr.length];
        opt[0] = arr[0];
        opt[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            int A = opt[i-2] + arr[i];
            int B = opt[i-1];
            opt[i] = Math.max(A, B);
        }
        return opt[arr.length-1];
    }
}
