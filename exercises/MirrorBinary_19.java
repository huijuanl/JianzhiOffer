package JianzhiOffer;

import java.util.Stack;

//操作给定的二叉树，将其变换为源二叉树的镜像。
public class MirrorBinary_19 {
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	  //递归算法，自己做出来的
	    public void Mirror(TreeNode root) {
	      if(root==null)
	          return;
	      Mirror(root.left);
	      Mirror(root.right);
	      TreeNode cur = root.left;
	      root.left = root.right;
	      root.right = cur;
	    }
	//  * 非递归的思想，利用队列和栈来做
    //	* 1.深度优先 stack
    //  * 2.广度优先 Queue(层序遍历也可以做)
	    public void Mirror2(TreeNode root){
	    	//先序遍历的非递归算法
	    	
	    if(root == null)
	    	return;
	    Stack<TreeNode>stack = new Stack<TreeNode>();
	    stack.push(root);
	    while(!stack.isEmpty()){
	    	TreeNode cur = stack.pop();
	    	TreeNode tmp = cur.left;
	    	cur.left = cur.right;
	    	cur.right = tmp;
	    	if(cur.right!=null)
	    		stack.push(cur.right);
	    	if(cur.left!=null)
	    		stack.push(cur.left);
	    	
	    }
	    	
	    	
	    }
}
