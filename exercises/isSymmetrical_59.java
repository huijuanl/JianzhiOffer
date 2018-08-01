package JianzhiOffer;

import java.util.Stack;

//请实现一个函数，用来判断一颗二叉树是不是对称的。
//注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
//代码很简单，关键还是知道怎么样才能判断一个
//二叉树是否对称，只要采用前序、中序、后序、层次遍历等任何一种遍历方法，分为先左后右和先
// 右后左两种方法，只要两次结果相等就说明这棵树是一颗对称二叉树。
public class isSymmetrical_59 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null)
            return true;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(pRoot);
        stack2.push(pRoot);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode cur1 = stack1.pop();
            TreeNode cur2 = stack2.pop();
            if(cur1==null&&cur2==null)
                continue;
            if (cur1==null||cur2==null||cur1.val != cur2.val)
                return false;
            stack1.push(cur1.right);
            stack1.push(cur1.left);
            stack2.push(cur2.left);
            stack2.push(cur2.right);

        }
        return true;
    }
}
