package Chapter6;/**
 * @author ZhouWu
 * @create 2019-08-27-16:47
 */

/**
 *@ClassName Problem54
 *@Description TODO
 *@Version 1.0
 */



public class Problem54 {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
    }

    public static void main(String[] args) {

    }

    TreeNode KthNode(TreeNode root, int k) {
        TreeNode target = null;
        if (root == null) return null;
        if (root.left != null)  target = KthNode(root.left, k);
        if (target == null) {
            if (k == 1) target = root;
            k--;
        }
        if (target == null && root.right != null) KthNode(root.right, k);
        return target;
    }
}
