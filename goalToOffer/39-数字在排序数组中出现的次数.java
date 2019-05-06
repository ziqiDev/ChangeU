/*
统计一个数字在排序数组中出现的次数。
*/
public class Solution {
    public int GetNumberOfK(int [] array , int k) {
       if(array==null||array.length==0){
           return 0;
       }
       int start = getFirstK(array,k,0,array.length-1);
        int end = getLastK(array,k,0,array.length-1);
        if(start==-1||end==-1){
            return 0;
        }
        return end-start+1;
    }
    
   public int getFirstK(int[]array,int k,int left, int right){
       if(left>right){
           return -1;
       }
       int mid = (right-left)/2 +left;
       if(array[mid]==k){
           if(mid==0|| (mid>0&&array[mid-1]<k)){
               return mid;
           }
           return getFirstK(array,k,left,mid-1);
       }else if(array[mid]>k){
           return getFirstK(array,k,left,mid-1);
       }else{
           return getFirstK(array,k,mid+1,right);
       }
   }
    public int getLastK(int[]array,int k,int left, int right){
       if(left>right){
           return -1;
       }
       int mid = (right-left)/2 +left;
       if(array[mid]==k){
           if(mid==right|| (mid<right&&array[mid+1]>k)){
               return mid;
           }
           return getLastK(array,k,mid+1,right);
       }else if(array[mid]>k){
           return getLastK(array,k,left,mid-1);
       }else{
           return getLastK(array,k,mid+1,right);
       }
   }
}
