package chap07_BinaryTree;

/**
 * Created by xing on 4/30/17.
 * 有一棵二叉树,请设计一个算法判断它是否是完全二叉树。

 给定二叉树的根结点root，请返回一个bool值代表它是否为完全二叉树。树的结点个数小于等于500。
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
public class CheckCompletion {
    public boolean chk(TreeNode root) {
        // write code here
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean flag = false; // 表征前面的节点是否已经是叶子节点
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    if (flag == true) {
                        return false;
                    }
                    queue.offer(node.left);
                    if (node.right != null) {
                        queue.offer(node.right);
                    } else {
                        flag = true;
                    }
                } else if (node.right != null) {
                    return false;
                }
            }
        }
        return true;
    }
}
