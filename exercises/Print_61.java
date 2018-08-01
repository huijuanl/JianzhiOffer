package JianzhiOffer;

import java.util.*;

//请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
// 第三行按照从左到右的顺序打印，其他行以此类推。
//链接：https://www.nowcoder.com/questionTerminal/91b69814117f4e8097390d107d2efbe0
//        来源：牛客网
/**
  * 大家的实现很多都是将每层的数据存进ArrayList中，偶数层时进行reverse操作，
  * 在海量数据时，这样效率太低了。
  * （我有一次面试，算法考的就是之字形打印二叉树，用了reverse，
  * 直接被鄙视了，面试官说海量数据时效率根本就不行。）
  *
  * 下面的实现：不必将每层的数据存进ArrayList中，偶数层时进行reverse操作，直接按打印顺序存入
  * 思路：利用Java中的LinkedList的底层实现是双向链表的特点。
  *     1)可用做队列,实现树的层次遍历
  *     2)可双向遍历,奇数层时从前向后遍历，偶数层时从后向前遍历
  */
public class Print_61 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null)
            return res;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();//先存右节点，再存左节点
        Stack<TreeNode> stack2 = new Stack<TreeNode>();//先存左节点，再存右节点
        stack1.add(pRoot);
        while (!stack1.isEmpty()) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            while (!stack1.isEmpty()) {
                TreeNode cur = stack1.pop();
                tmp.add(cur.val);
                if (cur.left != null)
                    stack2.add(cur.left);
                if (cur.right != null)
                    stack2.add(cur.right);
            }
            if(stack1.isEmpty()) {
                res.add(tmp);
                tmp = new ArrayList<Integer>();
            }
            if(stack2.isEmpty())
                return res;
            while (!stack2.isEmpty()){
                   TreeNode cur = stack2.pop();
                   tmp.add(cur.val);
                    if (cur.right != null)
                        stack1.add(cur.right);
                   if (cur.left != null)
                       stack1.add(cur.left);

            }
            if(stack2.isEmpty())
                res.add(tmp);
        }
        return res;
    }
    public ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(pRoot);
        int length = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                tmp.add(cur.val);
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            if(length%2==0)
                Collections.reverse(tmp);
            res.add(tmp);
            length++;
        }
        return res;
    }

}
