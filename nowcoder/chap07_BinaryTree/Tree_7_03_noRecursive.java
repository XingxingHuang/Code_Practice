package chap07_BinaryTree;

/**
 * Created by xing on 4/30/17.
 * 请用非递归方式实现二叉树的先序、中序和后序的遍历打印。

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
        list.add(preOrder(root));
        list.add(inOrder(root));
        list.add(postOrder(root));
        int[][] res = new int[3][list.get(0).size()];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < list.get(0).size(); j++) {
                res[i][j] = list.get(i).get(j);
            }
        }
        return res;
    }
    public ArrayList<Integer> preOrder(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }
    public ArrayList<Integer> inOrder(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null) {
            // 依次放入左节点到栈中，并且将其右节点放入stack
            while (root != null) {
                if (root.right != null) {
                    stack.push(root.right);
                }
                stack.push(root);
                root = root.left;
            }
            // 访问左节点, 如果没有右节点，将持续访问其父节点
            root = stack.pop();
            while (!stack.isEmpty() && root.right == null) {
                res.add(root.val);
                root = stack.pop();
            }
            // 此时需要加上一个节点
            res.add(root.val);
            // 访问下一个节点，左节点父亲的右节点
            if (!stack.isEmpty()) {
                root = stack.pop();
            } else {
                root = null;
            }
        }
        return res;
    }
    public ArrayList<Integer> postOrder(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = root;
        while (root != null) {
            // 左节点依次放入栈中
            while (root.left != null) {
                stack.push(root);
                root = root.left;
            }
            // 右边为空  或者  右边已经遍历过， 遍历root
            while (root != null && (root.right == null || root.right == pre)) {
                res.add(root.val);
                pre = root;
                if (stack.isEmpty()) {
                    return res;
                }
                root = stack.pop();
            }
            // 放入root，先遍历右节点。
            stack.push(root);
            root = root.right;
        }
        return res;
    }
}
