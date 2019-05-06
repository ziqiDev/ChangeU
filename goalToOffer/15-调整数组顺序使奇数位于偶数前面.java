/*
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
*/

public class Solution {
    public void reOrderArray(int [] array) {
        if(array ==null || array.length<=1){
            return;
        }
        int length = array.length-1;
        int i = 1;
        int j = 0;
        while(i<=length){
            int temp = array[i];
            j = i-1;
            if(array[i]%2==1){
                while(j>=0){
                    if(array[j]%2 ==0){
                        int tem = array[j+1];
                        array[j+1]= array[j];
                        array[j] =tem;
                        j--;
                    }else{
                        break;
                    }
                }
            }
            i++;
            array[j+1] = temp;
        }
    }
}
