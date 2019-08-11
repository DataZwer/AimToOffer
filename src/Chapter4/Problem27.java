package Chapter4;

/**
 *@ClassName Problem27
 *@Description TODO：二叉树的镜像
 *@Version 1.0
 */
public class Problem27 {

    public static class TreeNode {
        double value;
        TreeNode left;
        TreeNode right;
    }

    public static void MirrorRecursively(TreeNode pNode) {
        if (pNode == null) return;
        if (pNode.left == null && pNode.right == null) return;

        TreeNode tmp = pNode.left;
        pNode.left = pNode.right;
        pNode.right = tmp;

        if (pNode.left != null) MirrorRecursively(pNode.left);
        if (pNode.right != null) MirrorRecursively(pNode.right);
    }


    public static void main(String[] args) {
    }
}
