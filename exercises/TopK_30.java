package JianzhiOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TopK_30 {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer>result = new ArrayList<Integer>();
//        process(input,0,input.length-1,k,result);
        process2(input, k,result);
        return result;
    }
    //nlogk，当n很大时，大数据情况下，不会对原数组进行修改
    public static void process2(int[]input,int k, ArrayList<Integer>result){
        if(k>input.length)
            return;
        if(k==input.length){
            int tmp =0;
            while (tmp<input.length){
                result.add(input[tmp]);
                tmp++;
            }
            return;
        }
        PriorityQueue<Integer>MaxHeap = new PriorityQueue<Integer>(new MaxHeapComparator());
        for(int i= 0;i<k;i++)
            MaxHeap.add(input[i]);
        for(int i = k;i<input.length;i++){
            if(input[i]>=MaxHeap.peek())
                continue;
            else {
                MaxHeap.poll();
                MaxHeap.add(input[i]);
            }

        }
        while (!MaxHeap.isEmpty()){
          result.add(MaxHeap.poll());
        }
    }
    public static  class MaxHeapComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }
    //快排的思想,O(n)，缺点：会对原数组进行修改
    public static void process(int[]input,int left,int right,int m, ArrayList<Integer>result){
        if(m>(right-left+1))
            return;
        if(m==(right-left+1)){
            int tmp =left ;
            while (tmp<=right){
                result.add(input[tmp]);
                tmp++;
            }
            return;
        }
        int pivotIndex = partition(input,left,right);
        if((pivotIndex-left+1)==m){
            int tmp =0;
            while (tmp<m){
                result.add(input[left+tmp]);
                tmp++;
            }
        }
        else if ((pivotIndex-left+1)>m){
            process(input,left,pivotIndex-1,m,result);
        }
        else {
            int tmp =left ;
            while (tmp<=pivotIndex){
                result.add(input[tmp]);
                tmp++;
            }
            process(input,pivotIndex+1,right,m-(pivotIndex-left+1),result);

        }
    }
    public static int partition(int[]input,int left,int right){
        int pivot = input[left];
        int j = left;
        for(int i =left+1;i<=right;i++){
            if(input[i]<pivot) {
                j++;
                swap(input,i,j);
            }
        }
        swap(input,j,left);
        return j;//返回主元下标
    }
    public static void swap(int[]input,int i,int j){
        if(i>=input.length||j>=input.length)
            return;
        int tmp = input[i];
        input[i]=input[j];
        input[j]=tmp;

    }
    public static void main(String[]args){
        int []arr={7,5,1,6,2,9,3,8,11,12,0,4};
        ArrayList<Integer>result = GetLeastNumbers_Solution(arr,8);
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }
}
