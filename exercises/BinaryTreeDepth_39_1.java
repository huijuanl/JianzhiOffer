package JianzhiOffer;

import java.util.LinkedList;
import java.util.Queue;

//输入一棵二叉树，求该树的深度。
//从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
//两种方法：一种是递归解法，一种是层序遍历方法
public class BinaryTreeDepth_39_1 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //递归解法
    public int TreeDepth(TreeNode root) {
        if(root==null)
            return 0;
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        return 1+Math.max(rightDepth,leftDepth);

    }
    //层序遍历方法
    public int TreeDepth2(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode>queue=new LinkedList<TreeNode>();
        queue.add(root);
        int depth =0;
        while (!queue.isEmpty()){
            depth++;
            for(int i=0;i<queue.size();i++){//一次poll一层的数据
                TreeNode cur = queue.poll();
                if(cur.left!=null)
                    queue.add(cur.left);
                if(cur.right!=null)
                    queue.add(cur.right);
            }
        }
        return depth;
    }
}
