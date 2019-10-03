package LeetCode.BackTracking;/**
 * @author ZhouWu
 * @create 2019-09-19-14:46
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 *@ClassName Problem401
 *@Description TODO
 *@Version 1.0
 */
public class Problem401 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 10;
        while (t > 0) {
            int n = sc.nextInt();
            List res = readBinaryWatch(n);
            if (res != null) System.out.println(res.toString());
            else System.out.println("[]");
            t--;
        }

    }

    public static Stack<Integer> stack = new Stack<Integer>();
    private static String falg = null;
    private static List<String> upTimeList = new ArrayList<>();
    private static List<String> downTimeList = new ArrayList<>();
    private static List<String> TimeList = new ArrayList<>();
    private static List<String> readBinaryWatch(int num) {
        if (num > 9) return null;
        int m1, m2;
        for (m1 = 0; m1 <= num / 2; m1++) {
            m2 = num - m1;
            if (m1 >= 4 || m2 >= 6) continue;
            solution(m1, m2); // (0, 1)
            solution(m2, m1);
        }
        return null;
    }

    private static void solution(int up, int down) {
        int[] upTimeLoc = {0, 1, 2, 3};
        int[] downTimeLoc = {0, 1, 2, 3, 4, 5};
        falg = "up";
        func(upTimeLoc, up, 0, 0);
        falg = "down";
        func(downTimeLoc, down, 0, 0);
        print(upTimeList, downTimeList);
    }

    private static void print(List<String> up, List<String> down) {
        for (String u: up) {
            for (String d: down) {
                System.out.println(u + ":" + d);
            }
        }
    }

    private static void getTime(Stack<Integer> stack, String flag) {
        int[] B = new int[4];
        while (!stack.isEmpty()) B[stack.pop()] = 1;
        String time = "";
        for (int i = 0; i < B.length; i++) time += B[i];
        if (flag == "up") upTimeList.add(Integer.valueOf(time, 2).toString());
        if (flag == "down") downTimeList.add(Integer.valueOf(time, 2).toString());
    }


    // 选择从shu中选择targ个位置
    private static void func(int[] shu, int targ, int has, int cur) {
        if(has == targ) {
            System.out.println(stack);
            getTime(stack, falg);
            return;
        }
        for(int i=cur;i<shu.length;i++) {
            if(!stack.contains(shu[i])) {
                stack.add(shu[i]);
                func(shu, targ, has+1, i);
                stack.pop();
            }
        }
    }
}
