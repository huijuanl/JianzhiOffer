package JianzhiOffer;
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
//如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
//因为二叉搜索树的中序遍历是个增序序列
//所以对应于后续遍历中，最后一个元素为根节点，根节点左子树上的点都比根节点小，根节点的右子树都比根节点大
//用递归实现
public class BST_24 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0)
            return false;
        if(sequence.length == 1)
            return true;
        return process(sequence,0,sequence.length-1);

    }
    public boolean process(int[]sequence,int left,int right){
        if(right == left)
            return true;
        int root = sequence[right];
        int firstRight =left-1;
        if(sequence[left]>root){
            firstRight = left;
        }
        if(firstRight==left) {//右区间第一个节点的下标
            for (int i = (left+1); i < right; i++) {
                if(sequence[i]<root)
                    return false;
            }
        }
        else {
            for (int i = (left+1); i < right; i++) {
                if(sequence[i]>root){
                    if(firstRight == left-1){
                        firstRight = i;
                    }
                }
                else if(firstRight!=left-1)
                    return false;
            }
        }
        if(firstRight==-1||firstRight==left)
            return process(sequence,left,right-1);
        else
            return process(sequence,left,firstRight-1)&&process(sequence,firstRight,right);


    }
    public static void main(String[] args) {
        int[]arr = {5,7,6,9,4,10,8};
        BST_24 bst = new BST_24();
        System.out.println(bst.VerifySquenceOfBST(arr));

    }
}
