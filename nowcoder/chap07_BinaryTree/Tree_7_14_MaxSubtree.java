package chap07_BinaryTree;

/**
 * Created by xing on 5/1/17.
 * 有一棵二叉树，其中所有节点的值都不一样,找到含有节点最多 的搜索二叉子树,并返回这棵子树的头节点.

 给定二叉树的头结点root，请返回所求的头结点,若出现多个节点最多的子树，返回头结点权值最大的。
 */

// 下面解法摘自java的参考代码，与书商代码相同。

/**
 以节点node为头的树中，最大的搜索二叉子树只可能来自以下两种情况：
 1.来自node左子树上的最大搜索二叉子树是以node左孩子为头的，并且来自node右子树上的最大搜索二叉子树是以node右孩子为头的
 node左子树上的最大搜索二叉子树的最大值小于node的节点值，node右子树上的最大搜索二叉子树的最小值大于node的节点值
 那么以几点node为头的整棵树都是搜索二叉树。
 2.如果不满足第一种情况，说明以节点node为头的树整体不能连城搜索二叉树，这种情况下，以node为头的树上的最大搜索二叉子树是来自node
 的左子树上的最大搜索二叉子树和来自node的有字数上的最大搜索二叉子树之间，节点数较多的哪个。
 */
/**
 具体步骤如下：
 1.整体过程是二叉树的后续遍历
 2.遍历到当前节点记为cur，先遍历cur的左子树并收集4个信息，分别是左子树上，最大搜索二叉子树的头结点，节点数，树上最小值，树上最大值
 再遍历cur的右子树收集4个信息，分别是右子树上最大搜索二叉子树的头结点，节点数，最小值，最大值
 3.根据步骤2所收集的信息，判断是否满足第一种情况，也就是是否以cur为头的子树，整体都是搜索二叉树，如果满足第一种情况，就返回cur节点
 如果满足第二种情况，就返回左子树和右子树各自的最大搜索二叉树中，节点数较多的哪个树的头结点。
 4.对于如何返回4个信息，可以使用全局变量更新的方式，也可以使用数组的方式
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
public class MaxSubtree {
    public TreeNode getMax(TreeNode root) {
        // write code here
        if(root == null){
            return null;
        }
        int[] ret = new int[3];
        return postOrder(root,ret);
    }

    public TreeNode  postOrder(TreeNode root,int[]ret){
        if(root == null){
            ret[0] = Integer.MIN_VALUE;
            ret[1] = Integer.MAX_VALUE;
            ret[2] = 0;
            return null ;
        }
        TreeNode lnode = postOrder(root.left,ret);
        int lmax = ret[0];//0最大值，1最小值，2总结点数
        int lmin = ret[1];
        int lnum = ret[2];
        TreeNode rnode = postOrder(root.right,ret);
        int rmax = ret[0];
        int rmin = ret[1];
        int rnum = ret[2];

        ret[0]=Math.max(rmax,root.val);//更新最大值
        ret[1]=Math.min(lmin,root.val);

        if(lnode == root.left && rnode == root.right
                && lmax < root.val && rmin > root.val){
            ret[2] = rnum + lnum + 1;
            return root;
        }
        ret[2] = Math.max(rnum,lnum);
        return rnum >= lnum ? rnode : lnode; // 返回最大搜索子树的节点。
    }
}
