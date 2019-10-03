package LeetCode.BackTracking;/**
 * @author ZhouWu
 * @create 2019-09-19-16:33
 */

import org.junit.Test;

import java.util.*;

/**
 *@ClassName Problem784
 *@Description TODO
 *@Version 1.0
 */
public class Problem784 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String str = sc.nextLine();
            letterCasePermutation(str);
        }
    }

    private static List<String> strList  = new ArrayList<>();
    public static List<String> letterCasePermutation(String str) {
        if (str.length() == 0 || str.length() > 12) return null;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) <= 'z' && str.charAt(i) >= 'a')
                    || str.charAt(i) <= 'Z' && str.charAt(i) >= 'A') {
                count++;
            }
        }

        strList.add(str);
        int[] charLoc = new int[count];
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) <= 'z' && str.charAt(i) >= 'a')
                    || str.charAt(i) <= 'Z' && str.charAt(i) >= 'A') {
                charLoc[j++] = i;
            }
        }

        for (int i = 1; i <= count; i++) {
            func(charLoc, i, 0, 0, str);
            System.out.println(strList);
        }
        return strList;
    }

    private static Stack<Integer> stack = new Stack<Integer>();
    private static void func(int[] arr, int target, int has, int cur, String str) {
        if (has == target) {
            getRes(str);
            return;
        }

        for (int i = cur; i < arr.length; i++) {
            if (!stack.contains(arr[i])) {
                stack.push(arr[i]);
                func(arr, target, has+1, i, str);
                if (!stack.isEmpty()) stack.pop();
            }
        }
    }

    private static void getRes(String str) {
        String strTemp = "";
        int index = stack.pop();
        for (int i = 0; i < str.length(); i++) {
            if (i == index) {
                strTemp += "" + str.charAt(i);
                if (!stack.isEmpty()) index = stack.pop();
            } else {
                strTemp += "" + str.charAt(i);
            }
        }
        strList.add(strTemp);
    }
}
