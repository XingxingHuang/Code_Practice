package chap06_BinarySearch;

/**
 * Created by xing on 4/29/17.
 * 给定一棵完全二叉树的根节点root，返回这棵树的节点个数。如果完全二叉树的节点数为N，请实现时间复杂度低于O(N)的解法。

 给定树的根结点root，请返回树的大小。

 时间复杂度为 O( logN ^2)
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
public class CountNodes {
    public int count(TreeNode root) {
        // write code here
        if (root == null) {
            return 0;
        }
        int level = 0;
        int num = 0;
        while (root != null) {
            level++;
            if (height(root.left) >= height(root.right)) {
                root = root.left;
            } else {
                root = root.right;
                num++;
            }
        }
        return (1 << level) - 1 + num;
    }
    public int height(TreeNode root) {
        int n = 0;
        while (root != null) {
            n++;
            root = root.left;
        }
        return n;
    }
}
