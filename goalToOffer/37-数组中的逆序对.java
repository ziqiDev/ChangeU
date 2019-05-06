/*
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
*/
public class Solution {
    static int count =0;
    public int InversePairs(int [] array) {
        if(array==null || array.length<=1){
            return 0;
        }
        handlePairs(array,0,array.length-1);
        return count;
    }
    public void handlePairs(int[]array, int left,int right){
        if(left>=right){
            return;
        }
        int mid = (right-left)/2+left;
        handlePairs(array,left,mid);
        handlePairs(array,mid+1,right);
        merge(array,left,mid,right);
    }
    public void merge(int[]array, int left, int mid,int right){
        int [] nums = new int[right-left+1];
        int preLeft = left;
        int postLeft = mid+1;
        int index = 0;
        while(preLeft<=mid&&postLeft<=right){
            if(array[preLeft]<array[postLeft]){
                nums[index++] = array[preLeft++];
            }else{
                nums[index++] = array[postLeft++];
                count = count+ mid-preLeft+1;
                count %= 1000000007;
            }
        }
        while(preLeft<=mid){
            nums[index++] = array[preLeft++];
        }
        while(postLeft<=right){
            nums[index++] = array[postLeft++];
        }
        for(index= 0;index<nums.length;index++){
            array[left+index] = nums[index];
        }
    }

}
