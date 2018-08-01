package JianzhiOffer;
import java.util.ArrayList;
import java.util.Comparator;

//输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
//9~16   18~22
public class findContinuousSequence_41_2 {
    //时间复杂度最差为O(n)，这种方法仅仅适用于输入序列为{1,2,...n}的情况，利用了等差数列的性质
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res =new  ArrayList<ArrayList<Integer>>();
        if(sum<=0)
            return res;
         int maxInternal = (int) Math.sqrt(2*sum)-1;
         for(int i = maxInternal;i>=1;i--){
             if(2*sum%(1+i)==0&&(2*sum/(1+i)-i)%2==0){
                 int n = (2*sum/(1+i)-i)/2;
                 ArrayList<Integer> each = new ArrayList<Integer>();
                 for(int j = 0;j<=i;j++){
                     each.add(n+j);
                 }
                 res.add(each);
             }

         }
         return res;
    }
    public static class cmp implements Comparator<ArrayList<Integer>>{
        @Override
        public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
           return o1.get(0)-o2.get(0);
        }
    }
    //双指针法，两个指针初始都在最左边（不是首尾指针），且相差1，两个指针只可能++向右移动
    //当和大于sum时，small++；当小于sum时，bigger++
    public ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum) {
        int small = 1;
        int bigger = 2;
        ArrayList<ArrayList<Integer>> res =new  ArrayList<ArrayList<Integer>>();
        while (2*small<(sum)&&bigger<sum){
            if((small+bigger)*(bigger-small+1)==sum*2){
                ArrayList<Integer> each = new ArrayList<Integer>();
                for(int i = small;i<=bigger;i++){
                    each.add(i);
                }
                res.add(each);
                small++;
                bigger++;
            }
            else if((small+bigger)*(bigger-small+1)>sum*2){
                small++;
            }
            else bigger++;
        }
        return res;
    }


    public static void main(String[]args){
        findContinuousSequence_41_2 it =new findContinuousSequence_41_2();
        int sum =9;
        ArrayList<ArrayList<Integer>> res = it.FindContinuousSequence2(sum);
        for(int i=0;i<res.size();i++){
            for(int j =0;j<res.get(i).size();j++){
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println();
        }

    }
}
