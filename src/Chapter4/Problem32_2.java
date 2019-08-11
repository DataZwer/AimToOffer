package Chapter4;/**
 * @author ZhouWu
 * @create 2019-08-05-17:30
 */

import java.util.ArrayDeque;

/**
 *@ClassName Problem32_2
 *@Description TODO
 *@Version 1.0
 */
public class Problem32_2 {
    public static void main(String[] args) {

    }

    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    }

    public static void PrintTopToBottom(TreeNode root) {
        if (root == null) return;
        ArrayDeque<TreeNode> tmp = new ArrayDeque<>();
        tmp.add(root);
        int nextLevel = 0;
        int toBePrint = 1;

        while (true) {
            int len = tmp.size();
            if (len == 0) break;

            while (len > 0) {
                TreeNode nodeTmp = tmp.poll();
                System.out.print(nodeTmp.value + " ");
                --len;
                if (nodeTmp.left != null) {
                    nextLevel++;
                    tmp.add(nodeTmp.left);
                }
                if (nodeTmp.right != null) {
                    nextLevel++;
                    tmp.add(nodeTmp.right);
                }

                toBePrint--;
                if (toBePrint == 0) {
                    System.out.println();
                    toBePrint = nextLevel;
                    nextLevel = 0;
                }
            }
        }
    }
}
