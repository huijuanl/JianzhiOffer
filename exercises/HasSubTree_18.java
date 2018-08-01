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
	public static boolean hasSubtree(TreeNode root1,TreeNode root2) {
        if(root2==null)
			  return false;
        return process(root1,root2);
       	    
    }
    public static boolean process(TreeNode root1,TreeNode root2){
         if(root1==null&&root2!=null)
	           return false;
		 if(root2==null)
			  return true;
	     if(root1.val==root2.val)
	    	   return (
	    			   (process(root1.left, root2.left)
	    	            &&process(root1.right, root2.right))
	    			   )
	    			   ||process(root1.left, root2)||process(root1.right, root2);
	       else return
              process(root1.left, root2)||process(root1.right, root2);
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
	        head2.left = new TreeNode(9);
	        head2.right = new TreeNode(2);
	        System.out.println(hasSubtree(head1, head2));

	    }
	
}
