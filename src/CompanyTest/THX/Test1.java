package CompanyTest.THX;/**
 * @author ZhouWu
 * @create 2019-09-21-19:24
 */

/**
 *@ClassName Test1
 *@Description TODO
 *@Version 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        int[] arr = {2, 5, 10, 20, 50, 100};
        System.out.println(solution(arr, 15, 0));
    }

    public static int maxValue = Integer.MAX_VALUE;
    public static int solution(int[] arr, int t, int i) {
        if (t == 0) return 0;
        if (i >= 6 || t < arr[i]) return maxValue;
        return min(solution(arr, t, i+1), solution(arr, t-arr[i], i) + 1);
    }

    public static int min(int a, int b) {
        return a < b ? b : a;
    }
}
