package LeetCode.Array;/**
 * @author ZhouWu
 * @create 2019-09-07-17:18
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 *@ClassName Problem26
 *@Description TODO: 删除数组中的重复数字（双指针）
 *@Version 1.0
 */
public class Problem26 {
    public static void main(String[] args) {
        int t = 10;
        Scanner sc = new Scanner(System.in);
        while (t > 0) {
            String[] strs = sc.nextLine().split(",");
            int[] arr = new int[strs.length];
            int i  = 0;
            for (String s: strs) arr[i++] = Integer.parseInt(s);
            // System.out.println(Arrays.toString(arr));
            System.out.println(removeDuplicates(arr));
            t--;
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int p1 = 0;
        int p2 = nums.length-1;
        while (p1 != p2) {
            if (nums[p1] == nums[p1+1]) {
                move(nums, p1, p2);
                p2--;
            }
            else p1++;
        }
        System.out.println(Arrays.toString(nums));
        return p2+1;
    }

    private static void move(int[] nums, int p1, int p2) {
        for (int i = p1; i < p2; i++) nums[i] = nums[i+1];
    }
}
