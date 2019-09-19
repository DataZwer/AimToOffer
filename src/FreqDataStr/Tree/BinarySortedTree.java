package FreqDataStr.Tree;/**
 * @author ZhouWu
 * @create 2019-08-05-21:10
 */

/**
 *@ClassName BinarySortedTree
 *@Description TODO
 *@Version 1.0
 */
public class BinarySortedTree {

    static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;
    }



    /**
     * @Description: SearchBST is TODO: 查找指定元素element是否在树中存在，如果查找失败确认其添加的位置,查找成功直接返回
     * @param: t:从此节点开始
     * @param: f:保存t的父节点
     * @param: p:查找成功，p指向数据元素节点
     * @return: boolean
     */
    public boolean SearchBST(TreeNode t, int key, TreeNode f, TreeNode p) {
        if (t == null) {
            p = f;
            return false;
        }
        if (t.value < key) {
            return SearchBST(t.left, key, t, p);
        } else if (t.value > key) {
            return SearchBST(t.right, key, t, p);
        } else {
            p = t;
            return true;
        }
    }

    /**
     * @Description: InserBST is TODO:
     * @param: [elem]
     * @return: boolean
     */
    public boolean InserBST(TreeNode root, int elem) {
        if (root == null) return false;

        TreeNode p = new TreeNode();
        if (!SearchBST(root, elem, null, p)) {
            TreeNode s = new TreeNode();
            s.value = elem;

            if (p != null) {
                root = p;
            }
            else if (elem < root.value) {
                root.left = s;
            } else {
                root.right = s;
            }
        }
        return false;
    }

}
