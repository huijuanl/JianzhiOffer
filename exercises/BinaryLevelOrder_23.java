package JianzhiOffer;
//从上往下打印出二叉树的每个节点，同层节点从左至右打印。
//其实就是二叉树的层序遍历
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryLevelOrder_23 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;//注意这儿最好不要return null，会抛出空指针异常
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            result.add(cur.val);
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
        return result;
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
        BinaryLevelOrder_23 it = new BinaryLevelOrder_23();
        ArrayList<Integer>result =it.PrintFromTopToBottom(head);
        for(int i=0;i<result.size();i++)
        System.out.println(result.get(i));



    }
}
