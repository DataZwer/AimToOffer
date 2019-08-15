package CompanyTest.ZJTD;/**
 * @author ZhouWu
 * @create 2019-08-11-20:30
 */

import org.junit.Test;

import java.util.Scanner;

/**
 *@ClassName Main2
 *@Description TODO
 *@Version 1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] s = new int[n+k-1];
        for(int i = 0; i < s.length; i++) {
            s[i] = scanner.nextInt();
            if (s[i] != 0 || s[i] != 1) System.exit(0);
        }

        int f = 1;
        int[] b = new int[k];
        for (int i = 0; i < s.length; i++) {
            b[i] = func1(b, s, i);
        }
    }

    private static int func1(int[] b, int[] s, int sIndex) {

        return 0;
    }



    @Test
    public void test1() {

        System.out.println(1 ^ 1);
        System.out.println(1 ^ 0);
    }


}
