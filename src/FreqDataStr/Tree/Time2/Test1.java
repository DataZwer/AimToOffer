package FreqDataStr.Tree.Time2;/**
 * @author ZhouWu
 * @create 2019-09-11-11:03
 */

import org.junit.Test;

import java.util.Stack;

/**
 *@ClassName Test1
 *@Description TODO
 *@Version 1.0
 */
public class Test1 {
    static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;
    }
    private static TreeNode[] treeNodes = new TreeNode[6];
    static {
        int[] arr = new int[]{5, 4, 7, 9, 10, 6};
        for (int i = 0; i < arr.length; i++) {
            treeNodes[i] = new TreeNode();
            treeNodes[i].value = arr[i];
        }
        treeNodes[0].left = treeNodes[1];
        treeNodes[0].right = treeNodes[4];
        treeNodes[1].left = treeNodes[2];
        treeNodes[1].right = treeNodes[3];
        treeNodes[4].right = treeNodes[5];
    }

    @Test
    public void test1() {
        preOrderTraversal(treeNodes[0]);
        System.out.println("**************************");
        inOrderTraversal(treeNodes[0]);
        System.out.println("**************************");
        postOrderTraversal(treeNodes[0]);

    }

    private static void preOrderTraversal(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.push(root);
                System.out.print(root.value + " ");
                root = root.left;
            } else {
                root = stack.peek();
                if (root != null) root = root.right;
                stack.pop();
            }
        }
        System.out.println();
    }

    private static void inOrderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (!stack.empty()) {
                root = stack.peek();
                System.out.print(root.value + " ");
                if (root != null) root = root.right;
                stack.pop();
            }
        }
        System.out.println();
    }

    private static void postOrderTraversal(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root);
        while (!stack1.empty()) {
            root = stack1.pop();
            stack2.push(root);
            if (root.left != null) stack1.push(root.left);
            if (root.right != null) stack1.push(root.right);
        }

        while (!stack2.empty()) System.out.print(stack2.pop().value + " ");
        System.out.println();
    }






}
