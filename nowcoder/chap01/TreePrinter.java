package chap01;
import java.util.*;
import utils.TreeNode;

//public class TreeNode {
//    int val = 0;
//    TreeNode left = null;
//    TreeNode right = null;
//    public TreeNode(int val) {
//        this.val = val;
//    }
//}
public class TreePrinter {
    public int[][] printTree(TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res.add(new ArrayList<Integer>());
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                res.get(res.size() - 1).add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        int[][] ans = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = new int[res.get(i).size()];
            for (int j = 0; j < res.get(i).size(); j++) {
                ans[i][j] = res.get(i).get(j);
            }
        }
        return ans;
    }
}
