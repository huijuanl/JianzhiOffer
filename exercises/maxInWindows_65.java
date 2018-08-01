package JianzhiOffer;
//给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
// 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
// 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
//双端队列里存入的是数字所在的下标
//当一个数字的下标与当前处理数字的下标之差大于或等于滑动窗口的大小时，这个数字已经从窗口中滑出，可以从队列中删除了
/**
 * 用一个双端队列，队列第一个位置保存当前窗口的最大值，当窗口滑动一次
 * 1.判断当前最大值是否过期
 * 2.新增加的值从队尾开始比较，把所有比他小的值丢掉
 */
public class maxInWindows_65 {
    //时间复杂度为O(N)
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (size < 1)
            return res;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < num.length; i++) {
            //依次删除队头元素小于num[i]的值
            while (!deque.isEmpty() && num[deque.peekFirst()] < num[i]) {
                deque.pollFirst();
            }
            //依次删除队尾元素小于num[i]的值
            while (!deque.isEmpty() && num[deque.peekLast()] < num[i]) {
                deque.pollLast();
            }
            //添加当前num[i]的下标到双端队列中
            deque.addLast(i);
            //添加之后队列中下标的范围大于滑动窗口，则删除队头一个元素
            if ((deque.peekLast() - deque.peekFirst() + 1) > size) {
                deque.pollFirst();
            }
            //添加最大值到结果集中
            if (i >= (size - 1)) {
                res.add(num[deque.peekFirst()]);
            }


        }
        return res;
    }

    //时间复杂度为O(n*size)
    public ArrayList<Integer> maxInWindows1(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int[][] dp = new int[num.length][size + 1];
        if (size < 1)
            return res;
        for (int i = 0; i < num.length; i++)
            dp[i][1] = num[i];
        //dp[i][j]表示第i个数字结尾的size为j的滑动窗口的最大值
        for (int i = 0; i < num.length; i++)
            for (int j = 2; j <= size; j++) {
                dp[i][j] = num[i];
                if ((i - 1) >= 0)
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i][j]);

            }
        for (int i = size - 1; i < num.length; i++)
            res.add(dp[i][size]);
        return res;
    }

    public static void main(String[] args) {
        maxInWindows_65 it = new maxInWindows_65();
        int[] brr = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1};
        int[] crr = {10, 14, 12, 11};
        ArrayList<Integer> res = it.maxInWindows(arr, 3);
        for (int i = 0; i < res.size(); i++)
            System.out.println(res.get(i));
    }
}
