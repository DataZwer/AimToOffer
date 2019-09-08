package Chapter6;/**
 * @author ZhouWu
 * @create 2019-08-30-20:28
 */

/**
 *@ClassName Problem58_2
 *@Description TODO
 *@Version 1.0
 */
public class Problem58_2 {

    public static void main(String[] args) {
        char[] str = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        System.out.println(leftRotateString(str, 2));

    }
    public static String leftRotateString(char[] chars,int n) {
        if(chars==null ||chars.length<=0)
            return String.valueOf(chars);
        if(n<=0 || n>chars.length)
            return String.valueOf(chars);
        reverse(chars,0,n-1);
        reverse(chars,n,chars.length-1);
        reverse(chars,0,chars.length-1);
        return String.valueOf(chars);
    }

    private static void reverse(char[] chars, int start,int end){
        while(start<end){
            char temp=chars[start];
            chars[start]=chars[end];
            chars[end]=temp;
            start++;
            end--;
        }
    }
}
