package chapter3;
/**
 * @author ZhouWu
 * @create 2019-07-21-13:41
 */

import org.junit.Test;

/**
 *@ClassName Problem17
 *@Description TODO
 *@Version 1.0
 */
public class Problem17 {
    public static void main(String[] args) {
        Print1ToMaxOfDigits(3);
    }

    public static void Print1ToMaxOfDigits(int n) {
        if (n <= 0) return;
        char[] number = new char[n]; // 已经new出来了，初始化值为'\0'
        for (int i = 0; i < number.length; i++) number[i] = '0';

        while (!Increment(number)) { //如果最后一位没产生进位
            PrintNumber(number);
        }
    }
    // note: '0' --> 0 '\0' --> null

    private static boolean Increment(char[] number) {
        boolean isOverflow = false;
        int nTakeOver = 0; //进位
        int nLength = number.length;
        for (int i = nLength - 1; i >= 0; i--) {
            int nSum = number[i] - '0' + nTakeOver;
            if (i == nLength-1) nSum++;
            if (nSum >= 10) {
                if (i == 0) isOverflow = true;
                else {
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char)(nSum + '0');
                }
            } else {
                number[i] = (char)(nSum + '0');
                break;
            }
        }
        return isOverflow;
    }

    private static void PrintNumber(char[] number) {
        boolean isBeginning0 = true;
        int nLength = number.length;
        for (int i = 0; i < nLength; i++) {
            if (isBeginning0 && number[i] != '0') isBeginning0 = false;
            if (!isBeginning0) System.out.print(number[i]);
        }
        System.out.println();
    }



    @Test
    public void hehe() {
        char[] number = new char[10];
        for (char n: number){
            if (n == '\0') {
                System.out.println(n - '\0');
            }
        }
        char iToc= (char)(0 + '1');
        int ctoi = 1 - '0';
    }
}
