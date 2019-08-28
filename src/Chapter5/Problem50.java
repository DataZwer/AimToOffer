package Chapter5;/**
 * @author ZhouWu
 * @create 2019-08-24-16:04
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *@ClassName Problem50
 *@Description TODO: 第一个只出现1次的字符
 *@Version 1.0
 */
public class Problem50 {
    public static void main(String[] args) {
        String s = "abaccdeff";
        System.out.println(firstOnce(s));

        Scanner sc = new Scanner(System.in);
        StringBuilder str1 = new StringBuilder(sc.nextLine());
        StringBuilder str2 = new StringBuilder(sc.nextLine());
        replaceContainString(str1, str2);


    }

    private static char firstOnce(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return 0;
    }

    public static void replaceContainString(StringBuilder str1, StringBuilder str2) {
        List list = new ArrayList<Character>();
        for (int i = 0; i < str2.length(); i++) list.add(str2.charAt(i));
        for (int i = 0; i < str1.length(); i++) {
            if (list.contains(str1.charAt(i))) str1.replace(i, i+1, "");
        }
    }


}
