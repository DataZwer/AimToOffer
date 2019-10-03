package Time2;/**
 * @author ZhouWu
 * @create 2019-09-28-9:38
 */

import java.util.HashMap;

/**
 * @ClassName problem18
 * @Description TODO
 * @Version 1.0
 */
public class problem18 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static HashMap<Integer, Integer> hash = new HashMap<>();
    public static int[] preOrder;
    public static int[] inOrder;

    public static void main(String[] args) {

    }


    public TreeNode buildTree(int[] preorderT, int[] inorderT) {
        preOrder = preorderT;
        inOrder = inorderT;
        for (int i = 0; i < inOrder.length; i++) hash.put(inOrder[i], i);
        return dfs(0, preOrder.length-1, 0, inOrder.length-1);
    }

    private TreeNode dfs(int pl, int pr, int il, int ir) {
        if (pl > pr) return null;
        TreeNode root = new TreeNode(preOrder[pl]); //根节点
        int k = hash.get(root.val); //根节点的位置
        TreeNode left = dfs(pl + 1, pl + k - il, il, k - 1);
        TreeNode right = dfs(pl + k - il + 1, pr, k + 1, ir);
        root.left = left;
        root.right = right;
        return root;
    }

}

