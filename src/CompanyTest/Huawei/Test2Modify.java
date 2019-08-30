package CompanyTest.Huawei;/**
 * @author ZhouWu
 * @create 2019-08-29-15:44
 */

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *@ClassName Test2Modify
 *@Description TODO
 *@Version 1.0
 */
public class Test2Modify {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while (sc.hasNext()) {
            if ((n = sc.nextInt()) == 0) System.exit(0);
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
            solution(arr);
        }
    }

    public static void solution(int[] arr) {
        TreeSet set = new TreeSet();
        for (int i = 0; i < arr.length; i++) set.add(arr[i]);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
