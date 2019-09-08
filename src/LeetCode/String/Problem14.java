package LeetCode.String;/**
 * @author ZhouWu
 * @create 2019-09-07-15:24
 */

/**
 *@ClassName Problem14
 *@Description TODO: 最长公共子串( 连着输入)
 *@Version 1.0
 */
import org.junit.Test;

import java.util.*;
public class Problem14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 10;
        while (t > 0) {
            String[] strs = sc.nextLine().split(" ");
            int[] arr = new int[strs.length];
            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(strs[i]);
            System.out.println(Arrays.toString(arr));
            t--;
        }
    }


    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int minLen = getMinLen(strs);
        if (minLen == 0) return "";

        String res = "";
        for (int i = 0; i < minLen; i++) {
            int sum = 0;
            for (int j = 0; j < strs.length; j++) sum += strs[j].charAt(i);
            sum /= strs.length;
            char c = (char) sum;
            if (isRight(strs, c, i)) res += c;
            else return res;
        }
        return res;
    }

    private static boolean isRight(String[] strs, char c, int i) {
        for (int j = 0; j < strs.length; j++) if (c!= strs[j].charAt(i)) return false;
        return true;
    }

    public static int getMinLen(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (minLen > strs[i].length()) minLen = strs[i].length();
        }
        return minLen;
    }

    @Test
    public void test() {

        int t = 'f' + 'f' + 'f';
        int a = t/3;
        char c = (char) a;
        System.out.println(c);
    }
}
