package Chapter4;/**
 * @author ZhouWu
 * @create 2019-08-02-8:34
 */

/**
 *@ClassName Problem28
 *@Description TODO：对称二叉树
 *@Version 1.0
 */

public class Problem28 {
    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    }
    public static boolean isSymmetical(TreeNode pRoot) {
        return isSymmetical(pRoot, pRoot);
    }

    private static boolean isSymmetical(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot1 == null && pRoot2 == null) return true;
        if (pRoot1 == null || pRoot2 == null) return false;
        return isSymmetical(pRoot1.left, pRoot2.right)
                && isSymmetical(pRoot1.right, pRoot2.left);
    }
}
