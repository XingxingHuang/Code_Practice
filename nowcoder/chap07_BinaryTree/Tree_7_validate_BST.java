package chap07_BinaryTree;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * 判断一个二叉树是否为二叉搜索树
 * DFS, 注意需要用长整型表示最大最小值。
 * Interactive method 注意条件的判断。
 * @author  Xingxing Huang
 * @since   2017.04.17
 * @Time    O(n),
 * @param   TreeNode
 * @return  boolean
 */
// recursive simple method
public class Solution {
    private TreeNode pre;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (pre != null && root.val <= pre.val) {
            return false;
        }
        pre = root;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
}
 // iterative method
 public class Solution {
     public boolean isValidBST(TreeNode root) {
         Stack<TreeNode> stack = new Stack<>();
         TreeNode pre = null;
         while (root != null || !stack.isEmpty()) {
             while (root != null) {
                 stack.push(root);
                 root = root.left;
             }
             root = stack.pop();
             if (pre != null && root.val <= pre.val) {
                 return false;
             }
             pre = root;
             root = root.right;
         }
         return true;
     }
 }
 // recursive method
 public class Solution {
     public boolean isValidBST(TreeNode root) {
         return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
     }
     public boolean helper(TreeNode root, long min, long max) {
         if (root == null) {
             return true;
         }
         if (root.val <= min || root.val >= max) {
             return false;
         }
         return (helper(root.left, min, root.val)
                 && helper(root.right, root.val, max));
     }
 }
