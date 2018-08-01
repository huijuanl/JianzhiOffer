package JianzhiOffer;
//输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
//假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
public class reConBinaryTree_6 {
	
	
	 public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 //递归方法
	 public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
	        return process(pre,in,0,0,pre.length);
	    }
	 //process()中的a表示前序遍历中子树开始的位置，b表示中序遍历子树开始的位置，length表示子树的跨度
	     public  static TreeNode process(int[]pre,int[]in,int a,int b,int length){
		     if(length==0)
		         return null;
		     if(length==1){
		       TreeNode head = new TreeNode(pre[a]);
		         head.left =null;
		         head.right = null;  
		         return head;
		     }
		     TreeNode head = new TreeNode(pre[a]);
		     int i=0;
		     for(i=0;i<length;i++){
		       if(in[b+i]==pre[a])
		           break;
		     }
		     head.left = process(pre,in,a+1,b,i);
		     head.right = process(pre,in,a+i+1,b+i+1,length-i-1);
		     return head; 
		     }
	 public static void main(String[] args) {
	        
	        System.out.println("=========================");
	        int[]pre={1,2,3,4,5,6,7};
	        int[]in={3,2,4,1,6,5,7};
	        TreeNode head = reConstructBinaryTree(pre,in);
	        System.out.println("=========================");

	    }
}
