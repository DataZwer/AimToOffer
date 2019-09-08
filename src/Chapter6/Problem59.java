package Chapter6;/**
 * @author ZhouWu
 * @create 2019-09-01-13:51
 */

import java.util.ArrayDeque;
import java.util.ArrayList;


/**
 *@ClassName Problem
 *@Description TODO
 *@Version 1.0
 */
public class Problem59 {
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> max = new ArrayList<Integer>();
        if(num==null || num.length<=0 || size<=0 || size>num.length)
            return max;

        ArrayDeque<Integer> indexDeque = new ArrayDeque<Integer>();

        for (int i = 0; i < size-1; i++) {
            while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()])
                indexDeque.removeLast();
            indexDeque.addLast(i);
        }

        for(int i=size-1;i<num.length;i++){
            while(!indexDeque.isEmpty() && num[i]> num[indexDeque.getLast()])
                indexDeque.removeLast();
            if(!indexDeque.isEmpty() && (i-indexDeque.getFirst())>=size)
                indexDeque.removeFirst();
            indexDeque.addLast(i);
            max.add(num[indexDeque.getFirst()]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -4, 3, 3, 343, 1, 456, 343, 341};
        System.out.println(maxInWindows(arr, 5).toString());
    }

}
