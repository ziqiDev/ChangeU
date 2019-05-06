
/*
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
*/

public class Solution {
    public int RectCover(int target) {
        if(target<1){
            return 0;
        }
        if(target ==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        int pre =1;
        int last = 2;
        int res = 2;
        for(int index = 3;index<=target;index++){
            res = last+ pre;
            pre = last;
            last = res;
        }
        return res;
    }
}
