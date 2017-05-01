package chap07_BinaryTree;

/**
 * Created by xing on 4/30/17.
 * 有一棵二叉树，请设计一个算法，按照层次打印这棵二叉树。

 给定二叉树的根结点root，请返回打印结果，结果按照每一层一个数组进行储存，所有数组的顺序按照层数从上往下，且每一层的数组内元素按照从左往右排列。保证结点数小于等于500。
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
public class TreePrinter {
    public int[][] printTree(TreeNode root) {
        // write code here
        if (root == null) {
            return null;
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        levelTraverse(root, 1, res);
        int[][] ans = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = new int[res.get(i).size()];
            for (int j = 0; j < res.get(i).size(); j++) {
                ans[i][j] = res.get(i).get(j);
            }
        }
        return ans;
    }
    public void levelTraverse(TreeNode root, int level, ArrayList<ArrayList<Integer>> res) {
        if (root == null) {
            return;
        }
        if (res.size() < level) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level - 1).add(root.val);
        levelTraverse(root.left, level + 1, res);
        levelTraverse(root.right, level + 1, res);
    }
}
