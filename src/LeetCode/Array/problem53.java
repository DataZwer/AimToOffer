package LeetCode.Array;/**
 * @author ZhouWu
 * @create 2019-09-07-16:11
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

/**
 *@ClassName problem53
 *@Description TODO: 最大子序列和
 *@Version 1.0
 */
public class problem53 {
    public static void main(String[] args) {
        int t = 2;
        Scanner sc = new Scanner(System.in);
        while (t > 0) {
            String[] strs = sc.nextLine().split(",");
            int[] arr = new int[strs.length];
            int i  = 0;
            for (String s: strs) arr[i++] = Integer.parseInt(s);
            // System.out.println(Arrays.toString(arr));
            System.out.println(maxSubArray(arr));
            t--;
        }
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int nCurSum = 0;
        int nGreatSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nCurSum <= 0) nCurSum = nums[i];
            else nCurSum += nums[i];
            if (nCurSum > nGreatSum) nGreatSum = nCurSum;
        }
        return nGreatSum;
    }

    @Test
    public void test() {
        String str = "-34";
        System.out.println(Integer.parseInt(str) - 1 );

    }

}
