package Chapter6;/**
 * @author ZhouWu
 * @create 2019-08-29-11:07
 */

/**
 *@ClassName Problem56_2
 *@Description TODO: 数组中只出现一次的数字，其他数字出现3次
 *@Version 1.0
 */
public class Problem56_2 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 3, 4, 4, 4};
        int result = solution(arr);
        System.out.println(result);
    }

    private static int solution(int[] arr) {
        int[] bitSum = new int[32];
        for (int i = 0; i < arr.length; i++) {
            int bitMask = 1;
            // 取得每一位
            for (int j = 31; j >= 0; j--) {
                int bit = arr[i] & bitMask;
                if (bit != 0) {
                    bitSum[j] += 1;
                    bitMask = bitMask << 1; // 1, 10, 100, 1000....
                }
            }
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result += bitSum[i] % 3;
        }

        return result;
    }


}
