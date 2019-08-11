package Chapter2;/**
 * @author ZhouWu
 * @create 2019-07-19-14:47
 */

import org.junit.Test;

/**
 *@ClassName Problem15
 *@Description TODO
 *@Version 1.0
 */
public class Problem15 {
    @Test
    public void movingTest() {
        System.out.println(numberOf1_3(7));
    }

    public static int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0) count++;
            n = n >> 1;
        }
        return count;
    }

    public static int numberOf1_2(int n) {  // 防止为负数死循环的发生
        int count = 0;
        int flag = 1;
        while (flag != 0) {  // 移动32位的时候为零
            System.out.println(n & flag);
            if ((n&flag) != 0) count++; // 提取最低位
            flag = flag << 1;
            System.out.println("flag: " + flag);
        }
        return count;
    }

    // 一个规律
    public static int numberOf1_3(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n-1)&n;
        }
        return count;
    }

}
