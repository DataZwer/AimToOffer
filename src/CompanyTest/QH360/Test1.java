package CompanyTest.QH360;/**
 * @author ZhouWu
 * @create 2019-08-15-15:40
 */

import java.util.Scanner;

/**
 *@ClassName Test1
 *@Description TODO
 *@Version 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if (n < 2 || n > 1000) System.exit(0);

        long[][] ax = new long[n][2];
        for (int i = 0; i < ax.length; i++) {
            for (int j = 0; j < ax[i].length; j++) ax[i][j] = input.nextLong();
        }
        long result = func(ax);
        System.out.println(result);
    }

    private static long func(long[][] ax) {
        if (ax.length == 0) return 0;

        long maxX =Long.MIN_VALUE, maxY = Long.MIN_VALUE;
        for (int i = 0; i < ax.length; i++) {
            for (int j = 0; j < ax.length && j != i; j++) {
                long temp1 = Math.abs(ax[i][0] - ax[j][0]);
                long temp2 = Math.abs(ax[i][1] - ax[j][1]);
                if (maxX < temp1) maxX = temp1;
                if (maxY < temp2) maxY = temp2;
            }
        }

        if (maxX == 0) return maxY*maxY;
        if (maxY == 0) return maxX*maxX;
        return maxX*maxY;
    }
}
