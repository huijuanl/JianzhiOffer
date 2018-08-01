package JianzhiOffer;
//输入一棵二叉树，判断该二叉树是否是平衡二叉树。
//常规思想：先获得一个节点左子树的高度，然后获得右子树的高度，判断左右子树的高度差是否小于等于1
//若高度差小于等于一，则递归判断左子树和右子树是否分别平衡，如果都平衡，那么这个节点所形成的子树也平衡
//上面的常规思想，在计算树的高度的时候进行了多次递归(是从上到下判断是否平衡的思想)
//最优思想：从下至上（后序遍历的递归思想）
//后序遍历在返回到该节点时已经判断了左右子树是否平衡，以及拿到了左右子树的高度
//这个高度是作为形参传入递归函数的，每次进入递归函数，则创建左右子树高度的形参并调用递归函数获得修改后的值
//如果左右子树都平衡，判断左右子树的高度差是否小于等于1，若小于等于1，则该节点也平衡
//否则返回false
public class IsBalancedTree_39_2 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        int[]depth = new int[1];
        return IsBalanced(root,depth);
    }
    public boolean IsBalanced(TreeNode root,int[]depth) {
        if(root==null){
            depth[0]=0;
            return true;
        }
        int[]leftDepth = new int[1];
        int[]rightDepth = new int[1];
        boolean left= IsBalanced(root.left,leftDepth);
        boolean right = IsBalanced(root.right,rightDepth);
        if(!left||!right)
            return false;
        if(Math.abs(rightDepth[0]-leftDepth[0])>1)
            return false;
        else {
          depth[0] = Math.max(leftDepth[0],rightDepth[0])+1;
          return true;
        }
    }
}
