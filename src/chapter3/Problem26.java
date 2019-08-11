package chapter3;
import org.junit.Test;

public class Problem26 {
    public static class TreeNode {
        double value;
        TreeNode left;
        TreeNode right;
    }

    public static boolean HasSubtree(TreeNode pRoot1, TreeNode pRoot2) {
        boolean result = false;

        if (pRoot1 != null && pRoot2 != null) {
            if(Double.compare(pRoot1.value, pRoot2.value)==0)
                result = DoseTreeHaveTree2(pRoot1, pRoot2);
            if (!result)
                result = HasSubtree(pRoot1.left, pRoot2);
            if (!result)
                result = HasSubtree(pRoot1.right, pRoot2);
        }
        return result;
    }

    private static boolean DoseTreeHaveTree2(TreeNode pRoot1, TreeNode pRoot2) {
        // 下面两个if不能交换
        if (pRoot2 == null) return true;  // 停止条件之一：达到树B的叶子节点（B对应的节点匹配完成）
        if (pRoot1 == null) return false;  // 停止条件之二：达到树A的叶子节点还没有完成匹配 --> 凉凉
        if (Double.compare(pRoot1.value, pRoot2.value) < 0) return false; // 值不同直接false
        return DoseTreeHaveTree2(pRoot1.left, pRoot2.left) && DoseTreeHaveTree2(pRoot1.right, pRoot2.right);
    }

    @Test
    public void test1() {
        double d1 = 1.341;
        double d2 = 1.341;
        System.out.println(Double.compare(d1,d2));
    }
}
