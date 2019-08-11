package Chapter4;
/**
 * @author ZhouWu
 * @create 2019-08-06-11:26
 */

import java.util.Iterator;
import java.util.Stack;

/**
 *@ClassName Problem34
 *@Description TODO
 *@Version 1.0
 */
public class Problem34 {
    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    }

    public static void main(String[] args) {

    }

    public void FindPath(TreeNode root, int exceptedSum) {
        if (root == null) return;;

        Stack<TreeNode> path = new Stack<>();
        int currentSum = 0;
        FindPath(root, exceptedSum, path, currentSum);
    }

    private void FindPath(TreeNode root, int exceptedSum, Stack<TreeNode> path, int currentSum) {
        currentSum += root.value;
        path.push(root);

        boolean isLeaf = root.left == null && root.right == null;
        if (isLeaf && currentSum == exceptedSum) {
            System.out.println("A path is found");
            Iterator<TreeNode> iterable = path.iterator();
            while(iterable.hasNext()) {
                System.out.println(iterable.next().value + " ");
            }
        }

        // 非叶子节点，则遍历其子节点
        if (root.left != null) FindPath(root.left, exceptedSum, path, currentSum);
        if (root.right != null) FindPath(root.right, exceptedSum, path, currentSum);

        // 返回
        path.pop();
    }
}
