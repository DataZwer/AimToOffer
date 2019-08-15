package CompanyTest.PDD;/**
 * @author ZhouWu
 * @create 2019-08-11-15:12
 */

import java.util.Scanner;

/**
 *@ClassName AddTest
 *@Description TODO
 *@Version 1.0
 */
public class AddTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }

        // 多行输入输出
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0, x;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                x = sc.nextInt();
                ans += x;
            }
        }
        System.out.println(ans);
    }
}
