package AlgorithmDesignAndAnalysis.Chapter1Recur;/**
 * @author ZhouWu
 * @create 2019-09-08-15:25
 */

import java.util.Stack;

/**
 *@ClassName Combine
 *@Description TODO: 实现C(n, m)
 *@Version 1.0
 */
public class Combine {
    public static void main(String[] args) {
        int shu[] = {1,2,3,4,63,2};
        f(shu,4,0,0); // 从这个数组4个数中选择三个
    }
    public static Stack<Integer> stack = new Stack<Integer>();


    /**
     * @Description: f is TODO:
     * @param: [shu, targ, has: 计数, cur]
     * @return: void
     */
    private static void f(int[] shu, int targ, int has, int cur) {
        if(has == targ) {
            System.out.println(stack);
            return;
        }
        for(int i=cur;i<shu.length;i++) {
            if(!stack.contains(shu[i])) {
                stack.add(shu[i]);
                f(shu, targ, has+1, i);
                stack.pop();
            }
        }
    }
}

