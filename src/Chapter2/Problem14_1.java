package Chapter2;

import org.junit.Test;

public class Problem14_1 {
    public static void main(String[] args) {
        System.out.println(maxProdutAfterCutting_solution1(8));
    }

    public static int maxProdutAfterCutting_solution1(int length) {
        if (length < 2) return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;

        int[] products = new int[length+1]; //子问题的最优解
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;

        for (int i = 4; i <= length; i++) {  // 从下而上求解f(i)
            max = 0;
            for (int j = 1; j <= i/2; j++) {  // i/2：避免重复
                int product = products[j] * products[i-j];
                if (max < product) max = product;
                products[i] = max;
            }
        }
        max = products[length];
        return max;
    }

    @Test
    public void numberTest() {
        System.out.println(5/2);
    }

}
