package Chapter5;/**
 * @author ZhouWu
 * @create 2019-08-24-17:11
 */

import java.util.HashMap;

/**
 *@ClassName Problem50_2
 *@Description TODO
 *@Version 1.0
 */
public class Problem50_2 {
    public static void main(String[] args) {
        firstOnce("gogooogle");
    }

    public static void firstOnce(String s) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++) {
            if(map.containsKey(s.charAt(i))==false) {
                map.put(s.charAt(i),i);
            }else {
                map.put(s.charAt(i),-1);
            }

            if(i==0) {
                System.out.printf("i:%d\t%c\n",i,s.charAt(i));
            }else {
                int j = getFirst(map);
                if(j>=0) {
                    System.out.printf("i:%d\t%c\n",i,s.charAt(j));
                }else {
                    System.out.printf("i:%d\t%c\n",i,'_');
                }
            }
        }
    }

    public static int getFirst(HashMap<Character,Integer> map) {
        int i = 1;
        int count = 0;
        for(char key : map.keySet()) {
            int x = map.get(key);
            if(x>=0) {
                if(count==0)
                    i = x;

                if(x<i)
                    i = x;
                count++;
            }
        }
        if(count>0)
            return i;

        return -1;
    }

}
