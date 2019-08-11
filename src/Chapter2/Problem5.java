package Chapter2;

public class Problem5 {
    public static void main(String[] args) {

    }

    public static String replaceSpace(StringBuffer str) {
        if (str == null)
            return null;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equals(" ")) {
                sb.append("%20");
            }else {
                sb.append(str.charAt(i));
            }
        }
        return String.valueOf(sb);
    }

    public static String replaceSpace_2(StringBuffer str) {
        int oldLen = str.length();
        int len = oldLen;
        for(int i = 0; i < str.length(); ++i) {
            if(str.charAt(i) == ' ')
                len += 2;
        }
        str.setLength(len);

        for(int i = oldLen - 1, j = len - 1; i >= 0; ) {
            if(str.charAt(i) == ' ') {
                str.setCharAt(j--, '0');
                str.setCharAt(j--, '2');
                str.setCharAt(j--, '%');
                --i;
            }
            else {
                str.setCharAt(j--, str.charAt(i--));
            }
        }
        return str.toString();
    }
}


