package JianzhiOffer;

import java.util.ArrayList;

//输入一个递增排序的数组和一个数字S，在数组中查找两个数，
// 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
//思路：(1)设定两个首尾指针small和bigger
//(2)如果两个指针指向的和大于sum，则bigger--
//   如果小于sum,则small++
//   如果相等，则找到了一对符合条件的值，small++,bigger--
//循环条件为small<bigger
//算法的时间复杂度为O(n)
//找到乘积最小的：作者：马客(Mark)
//找到的第一组（相差最大的）就是乘积最小的。
// 可以这样证明：考虑x+y=C（C是常数），x*y的大小。
// 不妨设y>=x，y-x=d>=0，即y=x+d, 2x+d=C, x=(C-d)/2, x*y=x(x+d)=(C-d)(C+d)/4=(C^2-d^2)/4，
// 也就是x*y是一个关于变量d的二次函数，对称轴是y轴，开口向下。d是>=0的，d越大, x*y也就越小。
public class findNumbersWithSum_41_1 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int small =0;
        int bigger = array.length-1;
        while (small<bigger){
            if(array[small]+array[bigger]==sum){
                res.add(array[small]);
                res.add(array[bigger]);
                break;

            }
            else if(array[small]+array[bigger]>sum)
                bigger--;
            else small++;

        }
        return res;
    }
    public static void main(String[]args){
        findNumbersWithSum_41_1 it =new findNumbersWithSum_41_1();
        int[]arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int sum =21;
        ArrayList<Integer> res = it.FindNumbersWithSum(arr,sum);
        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i)+" ");

        }

    }
}
