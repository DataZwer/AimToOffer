package Test;/**
 * @author ZhouWu
 * @create 2019-08-13-16:43
 */

import org.junit.Test;

/**
 *@ClassName StringAndNumber
 *@Description TODO
 *@Version 1.0
 */
public class StringAndNumber {
    public static void main(String[] args) {
        String string = "13434";
        int a = Integer.parseInt(string);
        System.out.println(a);

        String string2 = String.valueOf(a);
        System.out.println(string2.getClass());

    }


    @Test
    public void test1() {
        System.out.println(10 / 3);
    }

}
