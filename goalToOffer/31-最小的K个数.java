/*
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
*/
import java.util.ArrayList;
public class Solution {
   public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList();
        if(input == null ||input.length==0||k<=0||k>input.length){
            return res;
        }
        int left = 0;
        int right = input.length-1;
        while(true){
            int part = partition(input,left,right);
            if(part == k-1){
                break;
            }else if(part>k-1){
                right = part -1;
            }else{
                left = part+1;
            }
        }
 
        for(int index = 0;index<k;index++){
            res.add(input[index]);
        }
        return res;
    }

 
    public int partition(int[]array,int left,int right){
        int temp = array[left];
        int low = left+1;
        int high = right;
        while(low<high){
            while(array[high]>temp&&high>=left){
                high--;
            }
 
            while(array[low]<temp&&low<=right){
                low++;
            }
            if(low<high){
                swap(array, low,high);
                low++;high--;
            }
        }
        swap(array,left,low-1);
        return low-1;
    }
    public void swap(int[]array, int low, int high){
        int temp = array[low];
        array[low] = array[high];
        array[high] = temp;
    }
}

