package JianzhiOffer;
//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
// 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
//做法就是用一个大顶堆和一个小顶堆，维持大顶堆的数都小于等于小顶堆的数，且两者的个数相等或差1。平均数就在两个堆顶的数之中。
//(1)保持大根堆size== 小根堆size或者(大根堆size-小根堆size==1)
//(2)保持大根堆中所有的数小于小根堆中的数
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetMedian_64 {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new cmp());
    public void Insert(Integer num) {
        if(maxHeap.isEmpty()){
            maxHeap.add(num);
        }
        else {
            if(num<=maxHeap.peek()){
                maxHeap.add(num);
                if((maxHeap.size()-minHeap.size())>1){
                    minHeap.add(maxHeap.poll());
                }
            }
            else {
                minHeap.add(num);
                if((minHeap.size()-maxHeap.size())>=1){
                    maxHeap.add(minHeap.poll());
                }
            }

        }
    }
    public Double GetMedian() {
        if(maxHeap.size()==0)
            return -1.0;
        if(minHeap.size()==maxHeap.size())
            return (minHeap.peek()+maxHeap.peek())/2.0;
        else return 1.0* maxHeap.size();

    }
    public class cmp implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }
}
