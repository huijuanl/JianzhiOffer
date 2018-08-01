package JianzhiOffer;
//统计一个数字在排序数组中出现的次数。
//数组为升序数组
//采用直接递归的方法，最坏的情况下的时间复杂度是O(n)
//可以使用两个递归函数分别找出第一个k的下标和最后一个k的下标，时间复杂度分别是O(log(n))
public class getNumberOfKInArray_38 {
    public int GetNumberOfK(int [] array , int k) {
        if(array.length==0)
            return 0;
        int last = FindLastIndex(array,k,0,array.length-1);
        if(last==-1)
            return 0;
        int first = FindFirstIndex(array,k,0,array.length-1);

        return last-first+1;
    }
    public int FindFirstIndex(int[]array,int k,int left,int right){
        if(left>right)
            return -1;
        if(left==right){
            if(k==array[left])
                return left;
            else return -1;
        }
        int mid =(left+right)/2;
        if(k<array[mid])
            return FindFirstIndex(array,k,left,mid-1);
        else if(k>array[mid])
            return FindFirstIndex(array,k,mid+1,right);
        else {
            if(mid==0||array[mid-1]!=k)
                return mid;
            else return FindFirstIndex(array,k,left,mid-1);

            }
    }
    public int FindLastIndex(int[]array,int k,int left,int right){
        if(left>right)
            return -1;
        if(left==right){
            if(k==array[left])
                return left;
            else return -1;
        }
        int mid =(left+right)/2;
        if(k<array[mid])
            return FindLastIndex(array,k,left,mid-1);
        else if(k>array[mid])
            return FindLastIndex(array,k,mid+1,right);
        else {
            if(mid==array.length-1||array[mid+1]!=k)
                return mid;
            else return FindLastIndex(array,k,mid+1,right);

        }
    }
    //直接递归，O(n)的算法
//    public int GetNumberOfK(int [] array , int k) {
//        if(array.length==0)
//            return 0;
//        return process(array,k,0,array.length-1);
//    }
//    public int process(int[]array,int k,int left,int right){
//        if(left>right)
//            return 0;
//        if(left==right){
//            if(k==array[left])
//                return 1;
//            else return 0;
//        }
//        int mid =(left+right)/2;
//        if(k<array[mid])
//            return process(array,k,left,mid-1);
//        else if(k>array[mid])
//            return process(array,k,mid+1,right);
//        else {
//            int result=1;
//            int cur = mid;
//            while (cur>left){
//                cur--;
//                if(array[cur]==k)
//                    result++;
//                else break;
//            }
//            cur = mid;
//            while (cur<right){
//                cur++;
//                if(array[cur]==k)
//                    result++;
//                else break;
//            }
//            return result;
//        }
//    }
    public static void main(String[] args) {
        int[] arr = {3,3,3,3,4,5};
        getNumberOfKInArray_38 it = new getNumberOfKInArray_38();
        int result = it.GetNumberOfK(arr,3);
        System.out.println(result);

    }
}
