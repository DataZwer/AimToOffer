package LeetCode.Array;/**
 * @author ZhouWu
 * @create 2019-09-08-16:36
 */

import org.junit.Test;

import java.util.*;

/**
 *@ClassName Problem15
 *@Description TODO: 3数之和
 *@Version 1.0
 */
public class Problem15 {
    public static void main(String[] args) {
        int t = 10;
        Scanner sc = new Scanner(System.in);
        while (t > 0) {
            String[] strs = sc.nextLine().split(",");
            int[] arr = new int[strs.length];
            int i  = 0;
            for (String s: strs) arr[i++] = Integer.parseInt(s);
            System.out.println(threeSum(arr));
            t--;
        }
    }

    private static List<List<Integer>> threeSum(int[] arr) {
        if (arr.length <= 2) return null;
        func(arr, 0, 0, 3);
        cheak(allList);
        return allList;
    }

    private static void cheak(List<List<Integer>> allList) {
        for (int i = 0; i < allList.size(); i++) {
            for (int j = 0; j <allList.size(); j++) {

            }
        }
    }


    public static Stack<Integer> stack = new Stack<Integer>();
    public static List<List<Integer>> allList = new ArrayList<List<Integer>>();
    /**
     * @param arr
     * @param targ：总数
     * @param has：选择数
     * @param cur：
     */
    private static void func(int[] arr, int targ, int has, int cur) {
        if(has == targ) {
            ArrayList<Integer> listTmp = new ArrayList<Integer>();
            int sum = 0;
            for (Object obj: stack.toArray()) sum += (Integer)obj;
            if (sum == 0) for (Object obj: stack.toArray()) listTmp.add((Integer)obj);
            if (listTmp.size() != 0) allList.add(listTmp);
            return;
        }

        for(int i=cur;i<arr.length;i++) {
            if(!stack.contains(arr[i])) {
                stack.add(arr[i]);
                func(arr, targ, has+1, i);
                stack.pop();
            }
        }
    }




    @Test
    public void test() {
        List<List<Integer>> all = new ArrayList<>();
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(2);

        all.add(l1);
        all.add(l2);

        System.out.println(all);

        int a = 1;
        a = a++;
        System.out.println(a);


        int[] arr = {1, 2, 3, 4};
        int[] brr = {1, 2, 3, 4};
        System.out.println(Arrays.equals(arr, brr));

        Arrays.fill(arr, 2);
        System.out.println(Arrays.toString(arr));

    }

}
