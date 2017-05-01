package chap07_BinaryTree;

/**
 * Created by xing on 4/30/17.
 * 有一棵二叉树，请设计一个算法判断这棵二叉树是否为平衡二叉树。

 给定二叉树的根结点root，请返回一个bool值，代表这棵树是否为平衡二叉树。
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
public class CheckBalance {
    public boolean check(TreeNode root) {
        // write code here
        if (root == null) {
            return false;
        }
        return balanced(root, 0) >= 0;
    }
    public int balanced(TreeNode root, int level) {
        if (root == null) {
            return level;
        }
        int left = balanced(root.left, level + 1);
        int right = balanced(root.right, level + 1);
        if ( left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right);
    }
}


public class CheckBalance {
    public static boolean check (TreeNode root){
        return chk(root) >= 0;
    }

    private static int chk (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = chk(root.left);
        int r = chk(root.right);//左右两边深度
        if (l < 0 || r < 0) {
            return -1;
        }
        if ((Math.abs(r - l) > 1)) {
            return -1;//当左右两边深度差超过1时 返回-1
        }
        return r > l ? r + 1 : l + 1;
    }
}
