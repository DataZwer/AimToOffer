package CompanyTest.Huawei;/**
 * @author ZhouWu
 * @create 2019-09-11-19:00
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 *@ClassName Test4
 *@Description TODO
 *@Version 1.0
 */

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String As = "";
        String Bs = "";
        int index = 3;
        while (str.charAt(index) != '}') As += str.charAt(index++);
        index = index+5;
        while (str.charAt(index) != '}') Bs += str.charAt(index++);
        int R = Integer.parseInt(str.charAt(str.length()-1)+"");
        int[] A = getArr(As);
        int[] B = getArr(Bs);
        Arrays.sort(A);
        Arrays.sort(B);
        solution(A, B, R);
    }


    private static void solution(int[] A, int[] B, int R) {
        int indexTmpI = 0;
        int indexTmpJ = 0;
        for (int i = 0; i < A.length; i++) {
            boolean flag1 = false;
            boolean flag2 = true;

            for (int j = 0; j < B.length; j++) {
                if (A[i] <= B[j] && (B[j] - A[i]) <= R) {
                    System.out.print("(" + A[i] + "," + B[j] + ")");
                    flag1 = true;
                    break;
                }

                if (A[i] <= B[j] && flag2 == true) {
                    indexTmpI = i;
                    indexTmpJ = j;
                    flag2 = false;
                }
            }
            if (flag1 == false && flag2 == false) System.out.print("(" + A[indexTmpI] + "," + B[indexTmpJ] + ")");
        }
    }

    private static int[] getArr(String s) {
        if (s == null) return new int[0];
        int len = s.split(",").length;
        int[] arr = new int[len];
        int i = 0;
        for (String e: s.split(",")) arr[i++] = Integer.parseInt(e);
        return arr;
    }
}