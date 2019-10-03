package Time2;/**
 * @author ZhouWu
 * @create 2019-09-27-22:06
 */


/**
 *@ClassName Problem16
 *@Description TODO
 *@Version 1.0
 */
public class Problem16 {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We are happy.");
        System.out.println(replaceSpaces(str));
    }

    public static String replaceSpaces(StringBuffer str) {
        if (str == null) return null;
        int length = str.length();
        int indexOfOriginal = length-1;
        for (int i = 0; i < str.length(); i++) if (str.charAt(i) == ' ') length+=2;

        str.setLength(length);
        int indexOfNew = length-1;

        while (indexOfNew > indexOfOriginal) {
            if (str.charAt(indexOfOriginal) != ' ') {
                str.setCharAt(indexOfNew--, str.charAt(indexOfOriginal));
            } else {
                str.setCharAt(indexOfNew--, '0');
                str.setCharAt(indexOfNew--, '2');
                str.setCharAt(indexOfNew--, '%');
            }
            indexOfOriginal--;
        }
        return str.toString();
    }


}
