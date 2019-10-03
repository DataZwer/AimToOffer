package LeetCode.BackTracking;/**
 * @author ZhouWu
 * @create 2019-09-19-20:44
 */

import java.util.ArrayList;
import java.util.List;

/**
 *@ClassName Problem784_2
 *@Description TODO
 *@Version 1.0
 */
public class Problem784_2 {

    public static void main(String[] args) {
        List<String> list = letterCasePermutation("a1b2");
        System.out.println(list);
    }

    public static List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<String>();
        dg(S.toCharArray(),0,ans); // 字符串转换字符数组，牛逼
        return ans;
    }
    public static void dg(char[] s,int i,List<String> ans){
        if(i==s.length){
            ans.add(String.valueOf(s));
            return;
        }

        dg(s,i+1,ans);
        if(s[i]<'0'|| s[i]>'9'){
            s[i] ^= (1<<5); // 切换大小写，牛逼
            dg(s,i+1,ans);
        }

    }

}
