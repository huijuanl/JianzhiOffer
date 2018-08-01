package JianzhiOffer;
//变态跳台阶
//一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

//  f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)
//
//    f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) = f(n-1) + f(n-1)
//
//    可以得出：
//
//    f(n) = 2*f(n-1)
//
//    
// 得出最终结论,在n阶台阶，一次有1、2、...n阶的跳的方式时，总得跳法为：
//
//              | 1,(n=0 )
//
//f(n) =       | 1 ,(n=1 )
//
//              | 2*f(n-1),(n>=2)
public class NStepsAdvanced_9_3 {
	//暴力递归
	public static int process1(int target){
		 if(target==0||target==1)
				return 1;
			int res = 0;
			for(int i=1;i<=target;i++){
				res+= process1(target-i);
			}
			return res;
		
	}
	//动态规划
	public static int process2(int target){
	    int[]dp =new int[target+1];
	    dp[0]=1;
	    dp[1]=1;
		for(int i=2;i<=target;i++){
			for(int k = 1;k<=i;k++){
				dp[i]+=dp[i-k];
				
			}
			
		}
		return dp[target];
		
	}
	//更简单的动态规划
	public static int process3(int target){
	    int[]dp =new int[target+1];
	    dp[0]=1;
	    dp[1]=1;
		for(int i=2;i<=target;i++){
			
				dp[i]=2*dp[i-1];
				
		}
			
		
		return dp[target];
		
	}
	
	
}
