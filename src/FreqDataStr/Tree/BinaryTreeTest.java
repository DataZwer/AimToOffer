package FreqDataStr.Tree;/**
 * @author ZhouWu
 * @create 2019-07-24-15:56
 */

import com.sun.jmx.remote.internal.ArrayQueue;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 *@ClassName BinaryTreeTest
 *@Description TODO
 *@Version 1.0
 */
public class BinaryTreeTest {

    public static TreeNode[] treeNodes = new TreeNode[6];

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


    /**
     * @Description: preOrderTraversel is TODO:前（递归）
     * @param: [root]
     * @return: void
     */
    public static void preOrderTraversel(TreeNode root) {
        if (root == null) return;
        System.out.print(root.value + " ");
        preOrderTraversel(root.left);
        preOrderTraversel(root.right);
    }


    /**
     * @Description: preWithouRec is TODO:前（非递归）
     * @param: [root]
     * @return: void
     */
    public static void preWithouRec(TreeNode root) {

        /*
            node = root
         *  node != null --> push, node = zuo
         *  node == null --> peek
         *  you != null node = you
         * */
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        while (root != null || !treeNodeStack.empty()) {
            if (root != null) {
                treeNodeStack.push(root);
                System.out.print(root.value + " ");
                root = root.left;
            } else {
                root = treeNodeStack.peek();
                if (root != null) root = root.right;
                treeNodeStack.pop();
            }
        }
    }

    @Test
    public void test1() {
        preOrderTraversel(treeNodes[0]);
        System.out.println();
        preWithouRec(treeNodes[0]);
    }

    /**
     * @Description: inOrderTraversel is TODO: 中
     * @param: [root]
     * @return: void
     */
    public static void inOrderTraversel(TreeNode root) {
        if (root == null) return;
        inOrderTraversel(root.left);
        System.out.print(root.value + " ");
        inOrderTraversel(root.right);
    }


    /**
     * @Description: inWithouRec is TODO: 中（非递归）
     * @param: [root]
     * @return: void
     */
    public static void inWithouRec(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        while (root != null || !treeNodeStack.empty()) {  // 外循环更新遍历的方向
            // 遍历所有的左子树直到左子树为空
            while (root != null) {
                treeNodeStack.push(root);
                root = root.left;
            }

            //访问右子树
            if(!treeNodeStack.isEmpty()) {
                root = treeNodeStack.peek();
                System.out.print(root.value + " ");

                treeNodeStack.pop();
                if (root != null) root = root.right;
            }
        }
    }

    @Test
    public void test2() {
        // inOrderTraversel(treeNodes[0]);
        System.out.println();
        inWithouRec(treeNodes[0]);
    }

    /**
     * @Description: postOrderTraversel is TODO: 后
     * @param: [root]
     * @return: void
     */
    public static void postOrderTraversel(TreeNode root) {
        if (root == null) return;
        postOrderTraversel(root.left);
        postOrderTraversel(root.right);
        System.out.print(root.value + " ");
    }

    /**
     * @Description: posWithoutRec is TODO: 后非递归
     * @param: [root]
     * @return: void
     */
    public void posWithoutRec(TreeNode root) {
        TreeNode cur = null;
        TreeNode pre = null; //
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        if (root != null) treeNodeStack.push(root);
        while (!treeNodeStack.isEmpty()) {
            cur = treeNodeStack.peek();
            if ((cur.left != null && cur.right != null) ||
                    pre != null && (cur.left==pre || cur.right==pre)) {
                System.out.print(cur.value + " ");
                pre = cur;
                treeNodeStack.pop();
            } else {
                if (cur.right != null) {
                    treeNodeStack.push(cur.right);
                }
                if (cur.left != null) {
                    treeNodeStack.push(cur.left);
                }
            }
        }
    }

    @Test
    public void test3() {
        postOrderTraversel(treeNodes[0]);
        System.out.println();
        posWithoutRec(treeNodes[0]);
    }


    /**
     * @Description: layerOrderTraversel is TODO: 层
     * @param: [root]
     * @return: void
     */
    public static void layerOrderTraversel(TreeNode root) {
        if (root == null) return;
        ArrayDeque<TreeNode> tmp = new ArrayDeque<>();
        tmp.add(root);
        while (true) {
            int len = tmp.size();
            if (len == 0) break;
            while (len > 0) {
                TreeNode nodeTmp = tmp.poll();
                System.out.print(nodeTmp.value + " ");
                --len;
                if (nodeTmp.left != null) tmp.add(nodeTmp.left);
                if (nodeTmp.right != null) tmp.add(nodeTmp.right);
            }
        }
    }

    public static void layerOrderTraversel_2(TreeNode root) {
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

    @Test
    public void test4() {
        layerOrderTraversel(treeNodes[0]);
        System.out.println("###########################");
        layerOrderTraversel_2(treeNodes[0]);
    }

    /**
     * @Description: getLeefNodeNum is TODO: 计算叶子节点的数量
     * @param: [root]
     * @return: int
     */
    public static int getLeefNodeNum(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left_n = getLeefNodeNum(root.left);
        int right_n = getLeefNodeNum(root.right);
        return left_n + right_n;
    }


    /**
     * @Description: getTreeWidth is TODO: 计算二叉树的宽度
     * @param: [root]
     * @return: int
     */
    public static int getTreeWidth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        ArrayDeque<TreeNode> tmp = new ArrayDeque<>();
        tmp.add(root);

        int maxWidth = 1;
        while (true) {
            int len = tmp.size();
            if (len == 0) break;
            while (len > 0) {
                TreeNode nodeTmp = tmp.poll();
                --len;
                if (nodeTmp.left != null) {
                    tmp.add(nodeTmp.left);
                }
                if (nodeTmp.right != null) {
                    tmp.add(nodeTmp.right);
                }
            }
            maxWidth = Math.max(maxWidth, tmp.size());
        }
        return maxWidth;
    }

    /**
     * @Description: GetKLevelNode is TODO: 获取第k层节点的个数(递归)
     * @param: [k]
     * @return: int
     */
    public int GetKLevelNodeRec(TreeNode pNode, int k) {
        if (pNode == null || k == 0) return 0;

        int leftLevelNode = GetKLevelNodeRec(pNode.left, k-1);
        int rightLevelNode = GetKLevelNodeRec(pNode.right, k-1);
        return leftLevelNode + rightLevelNode;
    }

    /**
     * @Description: GetLevelNode is TODO:  获取第k层节点的个数(非递归)
     * @param: [pNode, k]
     * @return: int
     */
    public int GetLevelNode(TreeNode pNode, int k) {
        if (pNode == null || k <= 0) return 0;

        // Stack<TreeNode> treeNodes = new Stack<>();
        ArrayDeque<TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.add(pNode);

        int count = 0;
        while (treeNodes.size()>0) {
            while (k > 0) {
                TreeNode nodeTmp = treeNodes.poll();
                if (nodeTmp.left != null) {
                    treeNodes.add(nodeTmp.left);
                    count++;
                }
                if (nodeTmp.right != null) {
                    treeNodes.add(nodeTmp.right);
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * @Description: GetTreeDepth is TODO: 获取二叉树的深度
     * @param: [root]
     * @return: int
     */
    public static int GetTreeDepth(TreeNode root) {

        if(root == null) return 0;
        int nLeft = GetTreeDepth(root.left);
        int nRight= GetTreeDepth(root.right);

        return nLeft > nRight ? (nLeft+1) : (nRight-1);
    }



    public static int left = 0;
    public static int right = 0;
    public static int depth = 0;
    /**
     * @Description: IsBalance is TODO: 平衡二叉树判断
     * @param: [root]
     * @return: boolean
     */
    private boolean IsBalance(TreeNode root) {
        if (root == null) {
            depth = 0;
            return true;
        }
        if (IsBalance(root.left) && IsBalance(root.right)) {
            int diff = left - right;
            if (depth <= 1 && diff >= -1) {
                depth = 1 + (left > right ? left : right);
                return true;
            }
        }
        return false;
    }

}
