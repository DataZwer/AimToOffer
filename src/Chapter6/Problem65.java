package Chapter6;/**
 * @author ZhouWu
 * @create 2019-09-02-17:27
 */

/**
 *@ClassName Problem65
 *@Description TODO: 用移位做加法
 *@Version 1.0
 */
public class Problem65 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        System.out.println(Add(a,b));
    }

    private static int Add(int a, int b) {
        int sum, carry;
        do {
            sum = a ^ b; // 相当于不进位加法
            carry = (a & b ) << 1;
            a = sum;
            b = carry;
        } while (b != 0);
        return a;
    }
}
