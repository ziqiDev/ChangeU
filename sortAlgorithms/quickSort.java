
class Solution{
public static void  sort(int [] nums ,int start, int end){
        if(start>=end){
            return;
        }
        int mark = start;
        int temp = nums[start];
        int i = start+1;
        int j = end;
        while(i<=j){
            while(temp>nums[i]){
                nums[mark++] =nums[i++];
            }
            while(temp<nums[j]){
                j--;
            }
            if(i<j){
                swap(nums,i,j);
            }

        }
        nums[mark] = temp;
        sort(nums,start,mark-1);
        sort(nums,mark+1,end);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
