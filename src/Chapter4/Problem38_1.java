package Chapter4;/**
 * @author ZhouWu
 * @create 2019-08-12-16:15
 */

import org.junit.Test;

/**
 *@ClassName arrroblem38
 *@Description TODO: 字符的全排列和数字的全排列
 *@Version 1.0
 */
public class Problem38_1 {

    // 字符串
    @Test
    public void test1() {
        String str = "abcd";
        char[] arr = str.toCharArray();
        permutationChar(arr, 0);
    }

    private static void permutationChar(char[] arr, int begin) {
        if (begin == arr.length-1) {  //边界条件
            String result = new String(arr); // 字符数组创建字符串
            System.out.println(result);
        } else {
            for (int i = begin; i < arr.length; i++) {
                swap(arr, begin, i);
                permutationChar(arr, begin + 1);
                swap(arr, begin, i);  // 回溯
            }
        }

    }

    private static void swap(char[] arr, int index1, int index2) {
        char temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private static int n = 0;
    private static int m = 0;
    private static int maxn = 11;
    private static int[] arr  = new int[maxn];
    private static boolean[] hasTable = new boolean[maxn];

    // 数字
    @Test
    public void test2() {
        n = 4;
        m = 3;
        permutationNumber_2(1); // 全排列
//        n = 5;
//        m = 2;
//        permutationNumber_2(1);
    }

    /**
     * @Description: permutationNumber is TODO: 对1-n的数进行全排列
     * @param: [index]
     * @return: void
     */
    public static void permutationNumber_1(int index) {
        if (index == n+1) {
            for (int i = 1; i <= n; i++) System.out.print(arr[i] + " ");
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (hasTable[i] == false) {
                arr[index] = i;
                hasTable[i] = true;
                permutationNumber_1(index+1);
                hasTable[i] = false;
            }
        }
    }

    public static void permutationNumber_2(int index) {
        if (index == m+1) {
            for (int i = 1; i <= m; i++) System.out.print(arr[i] + " ");
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (hasTable[i] == false) {
                arr[index] = i;
                hasTable[i] = true;
                permutationNumber_2(index+1);
                hasTable[i] = false;
            }
        }
    }

}
