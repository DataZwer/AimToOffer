package chapter3;/**
 * @author ZhouWu
 * @create 2019-07-21-15:08
 */

/**
 *@ClassName Problem17_2
 *@Description TODO
 *@Version 1.0
 */
public class Problem17_2 {
    public static void main(String[] args) {

    }
    public static void Print1ToMaxOfDigits(int n) {
        if (n < 0) return;
        char[] number = new char[n];
        for (int i = 0; i < n; i++) number[i] = '0';

        for (int i = 0; i < n; i++) {
            number[0] = (char)(i + '0');
            Pint1ToMaxOfDigitsRecu(number, n, 0);
        }
    }

    private static void Pint1ToMaxOfDigitsRecu(char[] number, int length, int index) {
        if (index == length-1) {
            PrintNumber(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            number[index+1] = (char)(i+'0');
            Pint1ToMaxOfDigitsRecu(number, length, index+1);
        }
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
}
