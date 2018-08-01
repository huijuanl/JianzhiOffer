package JianzhiOffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//请实现两个函数，分别用来序列化和反序列化二叉树
public class Serialize_62 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    String Serialize(TreeNode root) {
        String str = "";
        if (root == null)
            return "$,";
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur == null)
                str += "$,";
            else str += cur.val + ",";
            if (cur != null) {
                stack.push(cur.right);
                stack.push(cur.left);
            }

        }
        return str;
    }

    TreeNode Deserialize(String str) {
        String[] arr = str.split(",");
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        return DeProcess(queue);
    }

    TreeNode DeProcess(Queue<String> queue) {
        TreeNode root = null;
        if (!queue.isEmpty()) {
            root = CreateNode(queue.poll());
        }
        if(root!=null) {
            root.left = DeProcess(queue);
            root.right = DeProcess(queue);
        }
        return root;
    }

    public TreeNode CreateNode(String str) {
        if (str.equals("$"))
            return null;
        else return new TreeNode(Integer.valueOf(str));

    }
}
