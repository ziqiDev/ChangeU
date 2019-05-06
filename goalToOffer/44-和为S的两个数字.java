/*
输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int left = 0;
        int right = array.length-1;
        ArrayList<Integer> res = new ArrayList<Integer>();
        while(left<right){
            int currentSum = array[left]+array[right];
            if(sum==currentSum){
                res.add(array[left]);
                res.add(array[right]);
                break;
            }else if(sum>currentSum){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
}
