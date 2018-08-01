package JianzhiOffer;
//常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
// 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
// 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
// 给一个数组，返回它的最大连续子序列的和
public class findGreatestSumOfSubArray_31 {
    public int FindGreatestSumOfSubArray(int[] array) {
       return process1(array);
    }
    //动态规划
    public int process1(int[]array){
        //dp[i]表示(array[0....i])以i结尾的最大连续子序列的和
        int[]dp = new int[array.length];
        dp[0]=array[0];
        int sum = dp[0];
        for(int i = 1;i<dp.length;i++){
            if(dp[i-1]<0)
                dp[i]=array[i];
            else dp[i]=dp[i-1]+array[i];
            if(dp[i]>sum){
                sum = dp[i];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] arr = {6,-3,-2,7,-15,1,2,2};
        findGreatestSumOfSubArray_31 it = new findGreatestSumOfSubArray_31();
        int result = it.FindGreatestSumOfSubArray(arr);
        System.out.println(result);

    }
}
