package Chapter4;/**
 * @author ZhouWu
 * @create 2019-08-05-17:03
 */

import java.util.ArrayDeque;

/**
 *@ClassName Problem32
 *@Description TODO 二叉树层序遍历
 *@Version 1.0
 */
public class Problem32_1 {
    static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;
        public TreeNode() {
            this.value = 0;
            this.left = null;
            this.right = null;
        }
    }


    public static void PrintTopToBottom(TreeNode root) {
        if (root == null) return;
        ArrayDeque<TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            int layerSize = treeNodes.size();

            while (layerSize > 0) {
                TreeNode nodeTmp = treeNodes.poll();
                System.out.println(nodeTmp.value);
                if (nodeTmp.left != null) treeNodes.add(nodeTmp.left);
                if (nodeTmp.right != null) treeNodes.add(nodeTmp.right);
                layerSize--;
            }
        }
    }

}
