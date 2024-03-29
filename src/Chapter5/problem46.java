package Chapter5;/**
 * @author ZhouWu
 * @create 2019-08-21-16:00
 */

/**
 *@ClassName problem46
 *@Description TODO：动态规划
 *@Version 1.0
 */
public class problem46 {

    public static void main(String[] args) {
        int num = 12258;
        int n = String.valueOf(num).length();
        int[] f = new int[n + 1];
        f[n] = 1;

        for (int i = n - 1; i >= 1; i--) {
            if (i == n - 1) {
                f[i] = f[i + 1] + g(num + "", i) * 1;
                continue;
            }
            f[i] = f[i + 1] + g(num + "", i) * f[i + 2];
        }

        System.out.println(f[1]);
    }

    public static int g(String str, int i) {
        String tempStr = (str.charAt(i-1) + "") + (str.charAt(i) + "");
        int value = Integer.parseInt(tempStr);
        if (value >= 10 && value <= 25)
            return 1;
        else
            return 0;
    }
}
