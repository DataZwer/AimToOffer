package CompanyTest.XieCheng;/**
 * @author ZhouWu
 * @create 2019-09-03-18:58
 */

import java.util.Scanner;

/**
 *@ClassName Test1
 *@Description TODO
 *@Version 1.0
 */
public class Test1 {
    private static int minValue = 0;
    private static int n;
    private static int m;
    private static int k;
    private static int[][] move;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        move = new int[n][m];
        if (n <= 1 || m >= 100 || k > n * m) {
            System.out.println(0);
            System.exit(0);
        }
        int[][] zaw = new int[k][2];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 2; j++) {
                zaw[i][j] = sc.nextInt();
            }
            if (!(isValid(zaw[i][0], zaw[i][1]))) {
                System.out.println(0);
                System.exit(0);
            }
        }
        solution(zaw);
        System.out.println(minValue);
    }

    private static void solution(int[][] zaw) {
        func(0, 0, zaw,0);
    }

    private static void func(int x, int y, int[][] zaw, int count) {
        if (!isValid(x, y) || isMove(x, y)) return;
        if (isZaw(x, y, zaw)) return;
        count++;
        if (x == n-1 && y == m-1) {
            if (count < minValue) minValue = count;
        }
        move[x][y] = 1;
        func(x-1, y, zaw, count);
        func(x+1, y, zaw, count);
        func(x, y-1, zaw, count);
        func(x, y+1, zaw, count);
        move[x][y] = 0;
    }

    private static boolean isMove(int x, int y) {
        if (move[x][y] == 1) return true;
        return false;
    }

    private static boolean isZaw(int x, int y, int[][] zaw) {
        for (int i = 0; i < zaw.length; i++) {
            if (x == zaw[i][0] && y == zaw[i][1]) return true;
        }
        return false;
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x <= n-1 && y >=0 && y <= m-1;
    }
}