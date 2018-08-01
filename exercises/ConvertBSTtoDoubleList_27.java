package JianzhiOffer;

//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
// 要求不能创建任何新的结点，只能调整树中结点指针的指向。
//中序遍历是先遍历左子树，然后根节点，然后右子树
//利用递归思想
//可以先把左子树变成双向链表，右子树变成双向链表，然后把根节点与这两个链表串联起来
//串联规则为根节点的前驱为左子树链表的最后一个，左子树的后继为右子树链表的第一个
//(或者 先左子树，串联根节点，然后右子树，串联根节点)
public class ConvertBSTtoDoubleList_27 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return null;
        return process(pRootOfTree);//返回以root为根节点的二叉树形成的双向链表head
    }
    public TreeNode process(TreeNode  root){
        if(root == null)
            return null;
        TreeNode LeftHead = null;
        TreeNode RightHead = null;
        LeftHead = process(root.left);
        if (LeftHead!=null){
             TreeNode cur = LeftHead;
             while (cur.right !=null){
                 cur = cur.right;
             }
             cur.right = root;//左链表的最后一个与root串联起来
             root.left = cur;

         }
         RightHead = process(root.right);
         if(RightHead !=null){
             RightHead.left = root;
             root.right = RightHead;
         }
         if(LeftHead!= null)
             return LeftHead;
         else return root;
    }
    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        head.left.left.left = new TreeNode(1);
        head.right.left = new TreeNode(7);
        head.right.left.left = new TreeNode(6);
        head.right.right = new TreeNode(10);
        head.right.right.left = new TreeNode(9);
        head.right.right.right = new TreeNode(11);
        ConvertBSTtoDoubleList_27 it = new ConvertBSTtoDoubleList_27();
        TreeNode result =it.Convert(head);
        while (result!=null){
            System.out.println(result.val);
            result =result.right;
        }



    }
}
