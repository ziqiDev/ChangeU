/*
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
*/
import java.util.*;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] nums, int size)
    {    
       
        Deque<Integer> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if(size==0||nums==null||nums.length==0||nums.length<size){
            return res;
        }
        for(int index = 0;index<nums.length;index++){
            while(!queue.isEmpty()&&nums[queue.peekLast()]<nums[index]){
                queue.pollLast();
            }
            queue.addLast(index);
            if(queue.peekFirst()==index-size){
                queue.pollFirst();
            }
            if(index>=size-1){
                res.add(nums[queue.peekFirst()]);
            }
        }
	return res;
    }
}
