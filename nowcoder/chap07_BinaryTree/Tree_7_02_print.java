package chap07_BinaryTree;

/**
 * Created by xing on 4/30/17.
 * 请用递归方式实现二叉树的先序、中序和后序的遍历打印。

 给定一个二叉树的根结点root，请依次返回二叉树的先序，中序和后续遍历(二维数组的形式)。
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
public class TreeToSequence {
    public int[][] convert(TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 3; i++) {
            list.add(new ArrayList<Integer>());
        }
        preOrder((root), list.get(0));
        inOrder((root), list.get(1));
        postOrder((root), list.get(2));
        int[][] arr = new int[3][list.get(0).size()];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < list.get(0).size(); j++) {
                arr[i][j] = list.get(i).get(j);
            }
        }
        return arr;
    }
    public void preOrder(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }
    public void inOrder(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }
    public void postOrder(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.val);
    }
}
