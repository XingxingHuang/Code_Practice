package chap07_BinaryTree;

/**
 * Created by xing on 5/1/17.
 * 一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，使得这棵二叉树不再是搜索二叉树，请找到这两个错误节点并返回他们的值。保证二叉树中结点的值各不相同。

 给定一棵树的根结点，请返回两个调换了位置的值，其中小的值在前。

 注意： 此题较难。需要复习中序遍历的非递归形式
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
public class FindErrorNode {
    public int[] findError(TreeNode root) {
        // write code here
        TreeNode[] errs = new TreeNode[2];
        int[] res = new int[2];
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            // 遍历左孩子
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                // 往上遍历
                root = stack.pop();
                if (pre != null && pre.val > root.val) {
                    if (errs[0] == null) {
                        errs[0] = pre;
                    }
                    errs[1] = root;
                }
                // 设置前驱节点，并遍历右子树
                pre = root;
                root = root.right;
            }
        }
        res[0] = Math.min(errs[0].val, errs[1].val);
        res[1] = Math.max(errs[0].val, errs[1].val);
        return res;
    }
}
