package CompanyTest.ZJTD;/**
 * @author ZhouWu
 * @create 2019-08-11-19:48
 */

import java.util.Scanner;

/**
 *@ClassName Main1
 *@Description TODO
 *@Version 1.0
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n <= 0 || n > 100) System.exit(0);

        int[][] getUpTime = new int[n][2];
        for (int i = 0; i < getUpTime.length; i++) {
            for (int j = 0; j < getUpTime[i].length; j++) {
                getUpTime[i][j] = scanner.nextInt();
                if (j == 0 && ( getUpTime[i][j] < 0 || getUpTime[i][j] > 24) ) System.exit(0);
                if (j == 1 && ( getUpTime[i][j] < 0 || getUpTime[i][j] >= 60) ) System.exit(0);
            }
        }

        int x = scanner.nextInt();
        if (x < 0 || x > 100) System.exit(0);

        int hour = scanner.nextInt();
        int minute = scanner.nextInt();
        if (hour < 0 || hour >= 24 || minute < 0 || minute >= 60) System.exit(0);

        int minTimeInter = Integer.MAX_VALUE;
        int resHourIndex = 0;
        int interval = 0;
        for (int i = 0; i < getUpTime.length; i++) {
             interval = (hour*60+minute) - ((getUpTime[i][0]*60)+getUpTime[i][1] + x);
             if (interval < 0) continue;
             if (interval < minTimeInter) {
                 minTimeInter = interval;
                 resHourIndex = i;
             }
        }
        System.out.print(getUpTime[resHourIndex][0] + " " + getUpTime[resHourIndex][1]);
    }
}
