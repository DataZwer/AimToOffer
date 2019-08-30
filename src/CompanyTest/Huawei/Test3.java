package CompanyTest.Huawei;/**
 * @author ZhouWu
 * @create 2019-08-29-15:13
 */

import java.util.Scanner;

/**
 *@ClassName Test3
 *@Description TODO
 *@Version 1.0
 */
public class Test3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String hex = scan.nextLine();//读取一行
            solution(hex);
        }

    }

    private static void solution(String hex) {
        String subHex = hex.substring(2);
        subHex.toUpperCase();
        int decimal = 0;
        for (int i = 0; i < subHex.length(); i++) {
            if (hexChar2Decimal(subHex.charAt(subHex.length() - 1 - i)) != -1) {//从16进制数的最后一个字符开始获取
                decimal = (int) (decimal + hexChar2Decimal(subHex.charAt(subHex.length() - 1 - i)) * Math.pow(16, i));//乘以16的0次幂，然后++
            } else {
                System.out.println("enter error, decimal will be zero!");//如果等于-1则是非法字符
                break;
            }
        }
        System.out.println(decimal);
    }


    private static int hexChar2Decimal(char charAt) {
        if (charAt >= 'A' && charAt <= 'F')
            return charAt - 'A' + 10;//A~F转换成10进制数
        else if (charAt >= '0' && charAt <= '9')
            return charAt-'0';//0~9字符转换成10进制
        else
            return -1;
    }
}

