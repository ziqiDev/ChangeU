/*
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
*/
import java.util.*;
public class Solution {
    int count = 0;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(16, new Comparator<Integer>(){
        @Override
        public int compare(Integer o1, Integer o2){
            return o2.compareTo(o1);
        }
    });
    
    public void Insert(Integer num) {
        count++;
        if((count&1)==1){
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }else{
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }

    public Double GetMedian() {
        if(count==0){
            return null;
        }
        if((count&1)==1){
            return Double.valueOf(maxHeap.peek());
        }else{
            return Double.valueOf(minHeap.peek()+maxHeap.peek())/2;
        }
    }


}
