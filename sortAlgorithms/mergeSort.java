class Solution{
public void merge(int[] nums){
        if(nums.length<2){
            return;
        }
        int end = nums.length-1;
        int mid = end/2;
        int start = 0;
        mergeSort(nums,start,mid,end);

    }
    public void mergeSort(int[]nums,int start,int mid,int end){
        if(end<=start){
            return;
        }
        mergeSort(nums,start,(mid+start)/2,mid);
        mergeSort(nums,mid+1,(end+mid+1)/2,end);
        merge(nums,start,mid,mid+1,end);
    }

    public void merge(int[] nums ,int start,int end,int m,int n){
        int temp[] = new int[nums.length];
        int tempStart = start;
        int mark = start;
        while(start<=end&&m<=n){
            if(nums[start]<nums[m]){
                temp[tempStart++] = nums[start++];
            }else{
                temp[tempStart++] = nums[m++];
                count= count+1+end-start;
            }
        }
        while(start<=end){

            temp[tempStart++] = nums[start++];
        }
        while (m<=n){
            temp[tempStart++] = nums[m++];
        }
        for(;mark<=n;mark++){
            nums[mark] = temp[mark];
        }
        System.out.println(Arrays.toString(nums));
    }
}
