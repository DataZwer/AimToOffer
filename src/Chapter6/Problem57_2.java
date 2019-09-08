package Chapter6;/**
 * @author ZhouWu
 * @create 2019-08-30-19:44
 */

/**
 *@ClassName Problem57_2
 *@Description TODO: 和为s的连续正整数序列
 *@Version 1.0
 */
public class Problem57_2 {
    public static void main(String[] args) {
        int n = 15;
        solution(n);
    }

    public static void solution(int sum) {
        if (sum < 3) return;

        int smamll = 1;
        int big = 2;
        int middle = (1 + sum) / 2;
        int currentSum = smamll + big;

        while (smamll < middle) {
            if (currentSum == sum) PrintContinueSequence(smamll, big);
            while (currentSum > sum && smamll < middle) {
                currentSum -= smamll;
                smamll++;

                if (currentSum == sum)
                    PrintContinueSequence(smamll, big);
            }
            big++;
            currentSum += big;
        }
    }

    private static void PrintContinueSequence(int smamll, int big) {
        for (int i = smamll; i <= big ; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
