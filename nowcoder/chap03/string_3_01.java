package chap03;

/**
 * 对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。

 给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树。
 */
import java.util.*;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class IdenticalTree {
    public boolean chkIdentical(TreeNode A, TreeNode B) {
        // write code here
        if (A == null && B == null) {
            return true;
        } else if (A == null || B == null) {
            return false;
        }
        if (isSame(A, B)) {
            return true;
        }
        return chkIdentical(A.left, B) || chkIdentical(A.right, B);
    }
    public boolean isSame(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        } else if (A == null || B == null) {
            return false;
        }
        if (A.val == B.val) {
            return (isSame(A.left, B.left) && isSame(A.right, B.right));
        }
        return false;
    }
}
