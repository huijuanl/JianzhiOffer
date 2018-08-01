package JianzhiOffer;
//把只包含质因子2、3和5的数称作丑数（Ugly Number）。
// 例如6、8都是丑数，但14不是，因为它包含质因子7。
// 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
//用动态规划来算
//第N个丑叔一定是1...N-1丑叔里面的数*2或*3或
public class GetUglyNumber_34 {
    public int GetUglyNumber_Solution(int index) {
        if(index==1)
            return 1;
        if(index<=0)
            return 0;
        int[]dp =new int[index];
        dp[0]=1;
        for(int i = 1;i<dp.length;i++){
            dp[i]=dp[i-1]*2;
            for(int j = i-2;j>=0;j--){
                if(dp[j]*2>dp[i-1])
                    dp[i]=Math.min(dp[j]*2,dp[i]);
                if(dp[j]*3>dp[i-1])
                    dp[i]=Math.min(dp[j]*3,dp[i]);
                if(dp[j]*5>dp[i-1])
                    dp[i]=Math.min(dp[j]*5,dp[i]);
            }

        }
        return dp[index-1];
    }
    public static void main(String[] args) {
              GetUglyNumber_34 it = new GetUglyNumber_34();
        System.out.println(it.GetUglyNumber_Solution(7));

    }
}
