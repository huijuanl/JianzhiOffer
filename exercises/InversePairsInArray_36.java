package JianzhiOffer;
//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
// 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
//如输入:1,2,3,4,5,6,7,0
//输出为7
//第一种方法：动态规划
//第二种方法：归并排序，时间复杂度nlog(n)，空间复杂度o(n)(额外多了一个辅助数组，这个辅助数组只建了一次)
public class InversePairsInArray_36 {
    public int InversePairs(int [] array) {
        int[]copy = new int[array.length];//copy为array的辅助数组
        return process2(array,copy,0,array.length-1);
//        return process1(array);
    }
    //归并排序
    public int process2(int[]array,int[]copy,int left,int right){
        if(left == right)
            return 0;
        int mid = (left+right)/2;
        int p1 = left;
        int p2 =mid +1;
        int result = (process2(array,copy,left,mid)+process2(array,copy,mid+1,right))%1000000007;
        int i =left;
        while (p1<=mid&&p2<=right){
            if(array[p1]>array[p2]){
                result=(result+(mid-p1+1))%1000000007;//这里要注意：不是result++，而是result+(mid-p1+1)
                copy[i++]=array[p2++];
            }
            else {
                copy[i++]=array[p1];
                p1++;
            }
        }
        while (p1<=mid){
            copy[i++]=array[p1++];
        }
        while (p2<=right){
            copy[i++]=array[p2++];
        }
        for(int j = left;j<=right;j++){
            array[j]=copy[j];
        }
        return result;
    }
    //动态规划，时间复杂度O(n2)，时间复杂度过大，牛客网上通不过
    public int process1(int[]array){
        if(array.length==0)
            return 0;
        int[]dp = new int[array.length];
        dp[0]=0;
        for (int i =1;i<dp.length;i++){
            dp[i]=dp[i-1];
            for(int j=0;j<i;j++){
                if(array[j]>array[i])
                    dp[i]+=1;
            }
        }
        return dp[dp.length-1];

    }
    public static void main(String[] args) {
        int[]arr = {1,2,8,4,5,6,7,0};
        InversePairsInArray_36 it = new InversePairsInArray_36();
        System.out.println(it.InversePairs(arr));

    }
}
