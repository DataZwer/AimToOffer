package LeetCode.Array;/**
 * @author ZhouWu
 * @create 2019-09-07-19:50
 */

import java.util.Scanner;

/**
 *@ClassName Problem11
 *@Description TODO: 双指针最大面积
 *@Version 1.0
 */
public class Problem11 {
    public static void main(String[] args) {
        int t = 10;
        Scanner sc = new Scanner(System.in);
        while (t > 0) {
            String[] strs = sc.nextLine().split(",");
            int[] arr = new int[strs.length];
            int i  = 0;
            for (String s: strs) arr[i++] = Integer.parseInt(s);
            System.out.println(maxArea(arr));
            t--;
        }
    }

    public static  int maxArea(int[] height) {
        if (height.length == 0) return 0;
        int p1 = 0;
        int p2 = height.length-1;
        int maxS = 0;
        while (p1 != p2) {
            int curS = (p2 - p1) * (height[p1] < height[p2] ? height[p1] : height[p2]);
            if (curS > maxS) maxS = curS;
            if (height[p1] > height[p2]) p2--;
            else p1++;
        }
        return maxS;
    }
}
