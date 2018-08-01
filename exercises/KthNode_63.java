package JianzhiOffer;
import java.util.Stack;
//给定一棵二叉搜索树，请找出其中的第k小的结点。
// 例如（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
//思路：中序遍历寻找第k个
public class KthNode_63 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    TreeNode KthNode(TreeNode pRoot, int k)
    {   int index = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty()||pRoot!=null){
            while (pRoot!=null){
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            index++;
            TreeNode cur = stack.pop();
            if(index == k)
                return cur;
            pRoot=cur.right;
        }
        return null;
    }
}
