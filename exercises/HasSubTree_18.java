package JianzhiOffer;

//子结构和子树是不一样的。注意区分概念
//子结构一般用递归的方法来判断
  
public class HasSubTree_18 {
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	public static boolean isSubtree(TreeNode s, TreeNode t) {//判断t是否是s的子树
		if(s==null&&t==null)
			return true;
		if(s==null)
			return false;
		if(t==null)
			return false;
		if(s.val!=t.val)
			return isSubtree(s.left,t)||isSubtree(s.right,t);
		else {
			return (process(s.left,t.left)&&process(s.right,t.right))
					||isSubtree(s.left,t)||isSubtree(s.right,t);
		}

	}
	public static boolean process(TreeNode s1,TreeNode t1){//判断s1和t1是否结构和数值完全相等,先序遍历
		if(t1==null)
			return true;
		if(s1==null)
			return false;
		if(s1.val!=t1.val)
			return false;
		else return (process(s1.left,t1.left)&&process(s1.right,t1.right));

	}
	  public static void main(String[] args) {
		    TreeNode head1 = new TreeNode(8);
	        head1.left = new TreeNode(8);
	        head1.left.left = new TreeNode(9);
	        head1.left.right = new TreeNode(2);
	        head1.left.right.left = new TreeNode(4);
	        head1.left.right.right = new TreeNode(7);
	        head1.right = new TreeNode(7);
	        TreeNode head2 = new TreeNode(8);
	        head2.right = new TreeNode(2);
	        System.out.println(isSubtree(head1, head2));

	    }
	
}
