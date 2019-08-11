package chapter3;

/**
 * @author ZhouWu
 * @create 2019-07-20-12:24
 */

/**
 *@ClassName Problem16
 *@Description TODO
 *@Version 1.0
 */
public class Problem16 {
    public static boolean g_InvalidInput = false;
    public static void main(String[] args) {
        System.out.println(Power(2, -3));
    }

    public static double Power(double base, int exponent) {
        g_InvalidInput = false;
        if ((base == 0.0) && exponent < 0) {
            g_InvalidInput = true;
            return 0.0;
        }

        short absExponent = (short)exponent;
        if(exponent < 0) absExponent = (short)(-exponent);

        double result = PowerWithShortExponent_2(base, absExponent);
        if (exponent < 0) result = 1.0 / result;
        return result;
    }

    private static double PowerWithShortExponent(double base, short exponent) {
        double result = 1.0;
        for (int i = 1; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    // 提升效率
    private static double PowerWithShortExponent_2(double base, short exponent) {

        if (exponent == 0) return 1;
        if (exponent == 1) return base;

        double result =  PowerWithShortExponent_2(base, (short)(exponent >> 1));
        result *= result;
        if ((exponent & 0x1) == 1) result *= base; //判断指数是奇数的方法
        return result;
    }
}
