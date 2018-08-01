package JianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
public class Print_60 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res =  new ArrayList<ArrayList<Integer>>();
        if(pRoot==null)
            return res;
        Queue<TreeNode>queue = new LinkedList<TreeNode>();
        queue.add(pRoot);
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for(int i =0;i<size;i++){
                TreeNode cur = queue.poll();
                tmp.add(cur.val);
                if(cur.left!=null)
                    queue.add(cur.left);
                if(cur.right!=null)
                    queue.add(cur.right);
            }
            res.add(tmp);
        }
        return res;

    }
}
