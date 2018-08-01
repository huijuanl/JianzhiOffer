package JianzhiOffer;

import java.util.ArrayList;

//:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
// 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,
// 并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....
// 这样下去....直到剩下最后一个小朋友
//经典解法：循环链表(O(nm))
//优化算法: 动态规划: O(n)  f(n,m) = (f(n-1,m)+k+1)%n  k=(m-1)%n
//所以:f(n,m) = (f(n-1,m)+m)%n
public class LastRemaining_SolutionLastRemaining_45 {
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0)
            return -1;
        int[]dp = new int[n+1];
       for(int i =2;i<=n;i++){
           dp[i]=(dp[i-1]+m)%i;

       }
        return dp[n];
    }
    public int LastRemaining_Solution1(int n, int m) {
        if (n == 0)
            return -1;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            arr.add(i);
        }
        int i = 0;
        while (arr.size() != 1) {
            i = (m - 1 + i) % arr.size();
            arr.remove(i);
        }
        return arr.get(0);
    }

    public static void main(String[] args) {
        LastRemaining_SolutionLastRemaining_45 it = new LastRemaining_SolutionLastRemaining_45();
        System.out.println(it.LastRemaining_Solution(5, 3));


    }
}
