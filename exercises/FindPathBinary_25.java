package JianzhiOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
// 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
// (注意: 在返回值的list中，数组长度大的数组靠前)
public class FindPathBinary_25 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result =new ArrayList<>();
        ArrayList<Integer> curPath = new ArrayList<Integer>();
        if(root == null)
            return result;
        process(root,target,result,curPath);
        Collections.sort(result,new cmp());
        return result;
    }
    public static class cmp implements Comparator<ArrayList<Integer>>{
        @Override
        public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
            return o2.size()-o1.size();
        }
    }
    public void process(TreeNode root ,int target, ArrayList<ArrayList<Integer>> result,ArrayList<Integer>curPath){
         if(root.left == null&&root.right==null){
             curPath.add(root.val);
             if(target == root.val){
                 result.add((ArrayList<Integer>)curPath.clone());
             }
             return;
         }
        curPath.add(root.val);
         if(root.left!=null){
             process(root.left,target-root.val,result,curPath);
             curPath.remove(curPath.size()-1);
         }
        if(root.right!=null){
            process(root.right,target-root.val,result,curPath);
            curPath.remove(curPath.size()-1);
        }
    }
    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        head.left.left.left = new TreeNode(10);
        head.right.left = new TreeNode(7);
        head.right.left.left = new TreeNode(0);
        head.right.left.left.left = new TreeNode(0);
        head.right.right = new TreeNode(10);
        head.right.right.left = new TreeNode(9);
        head.right.right.right = new TreeNode(11);
        FindPathBinary_25 it = new FindPathBinary_25();
        ArrayList<ArrayList<Integer>>result =it.FindPath(head,20);
        for(int i=0;i<result.size();i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
