package Chapter2;
/**
 * @author ZhouWu
 * @create 2019-07-19-13:52
 */

/**
 *@ClassName Problem14_2
 *@Description TODO
 *@Version 1.0
 */
public class Problem14_2 {
    public static void main(String[] args) {
        System.out.println(maxProdoccAfterCutting_solution2(8));
    }

    public static int maxProdoccAfterCutting_solution2(int length) {
        if (length < 2) return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;

        // 尽可能多的减掉长度为3的绳子,能除尽3的部分
        int timesOf3 = length/3;

        //当绳子剩下的长度为4，不能再减去长度为3的绳子段
        //此时更好的方法是剪成长度为2的两段， 2*2 > 3*1
        if (length - timesOf3*3 == 1) timesOf3 -= 1;

        int timesOf2 = (length - timesOf3 * 3) / 2;
        return (int)( Math.pow(3, timesOf3)) * (int)(Math.pow(2, timesOf2));
    }
}
