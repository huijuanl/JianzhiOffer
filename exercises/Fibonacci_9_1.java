package JianzhiOffer;
//大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
//n<=39
public class Fibonacci_9_1 {
	  //动态规划
    public int getFibonacci(int n) {
    if (n==0)
        return 0;
	if(n==1||n==2)
			return 1;
		int[]dp=new int[n+1];
		dp[1]=1;
		dp[2]=1;
		for(int i=3;i<=n;i++){
			dp[i]=dp[i-1]+dp[i-2];
			}
		return dp[n];
    }
}
