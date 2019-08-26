package Chapter5;/**
 * @author ZhouWu
 * @create 2019-08-23-15:45
 */

/**
 *@ClassName Problem48
 *@Description TODO
 *@Version 1.0
 */
public class Problem48 {
    public static void main(String[] args) {
        System.out.println(longestSubStringWithout("abcdeb"));
    }

    private static int longestSubStringWithout(String str) {
        int[] position = new int[26];
        for (int i = 0; i < 26; i++) {
            position[i] = -1;
        }
        int curLen = 1;
        int maxLen = 1;
        position[str.charAt(0) - 'a'] = 0; //每个字符上次出现的下标
        for (int i = 1; i < str.length(); i++) {
            int index = position[str.charAt(i) - 'a']; // 字符串出现的位置
            if (index < 0 || index <= i - 1 - curLen) {
                curLen += 1;
            } else {
                curLen = i - index;
            }
            if (curLen > maxLen)
                maxLen = curLen;
            position[str.charAt(i) - 'a'] = i;
        }
        return maxLen;
    }


}
