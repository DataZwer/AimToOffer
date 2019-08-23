package Chapter5;/**
 * @author ZhouWu
 * @create 2019-08-19-17:00
 */

/**
 *@ClassName Problem42
 *@Description TODO
 *@Version 1.0
 */
public class Problem42 {
    public static void main(String[] args) {
        int[] arr = new int[] {1, -2, 3, 10, -4, 7, 2, -5};
        int result = FindGreatestSumOfSubArray(arr);
        System.out.println(result);

    }

    private static int FindGreatestSumOfSubArray(int[] arr) {
        if (arr.length == 0) return 0;

        int nCurSum = 0;
        int nGreatedSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (nCurSum <= 0) nCurSum =+ arr[i];
            else nCurSum += arr[i];

            if (nCurSum > nGreatedSum) nGreatedSum = nCurSum;
        }
        return nGreatedSum;
    }
}
