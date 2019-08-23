package CompanyTest.MGJ;

/**
 * @author ZhouWu
 * @create 2019-08-19-13:23
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 *@ClassName Main1
 *@Description TODO: 看清楚用什么分隔
 *@Version 1.0
 */
public class Main1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(",");
        int[] arr = new int[str.length];
        for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
        int result = candy(arr);
        System.out.println(result);
    }

    private static int candy(int[] ratings) {
        int sum = 0;
        if(ratings == null || ratings.length==0){
            return 0;
        }
        int count[] = new int[ratings.length];
        Arrays.fill(count,1);  // 没人发一颗糖(全填充)

        for(int i = 1; i < ratings.length; i++){
            if(ratings[i-1] < ratings[i]) {
                count[i] = count[i-1]+1;
            }
        }
        for(int i = ratings.length-1; i>0 ; i--){
            sum+=count[i];
            if(ratings[i] < ratings[i-1] && count[i] >= count[i-1]){
                count[i-1]=count[i]+1;
            }
        }

        sum += count[0];
        return sum;
    }
}