package Chapter6;/**
 * @author ZhouWu
 * @create 2019-09-02-17:01
 */

import java.util.LinkedList;
import java.util.List;

/**
 *@ClassName Problem62
 *@Description TODO: 圆圈中最后剩下的数字
 *@Version 1.0
 */


public class Problem62 {

    public static void main(String[] args) {
        System.out.println(lastRemaining(5, 3));
    }

    public static int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        // 要删除元素的位置
        int idx = 0;
        // 开始计数的位置
        int start = 0;
        while (list.size() > 1) {
            // 只要移动m-1次就可以移动到下一个要删除的元素上
            for (int i = 1; i < m; i++) {
                idx = (idx + 1) % list.size(); // 【A】
            }
            list.remove(idx);
            // 确保idx指向每一轮的第一个位置
            // 下面的可以不用，【A】已经可以保证其正确性了，可以分析n=6，m=6的第一次删除情况
            //  if (idx == list.size()) {
            //      idx = 0;
            //  }
        }
        return list.get(0);
    }
}
