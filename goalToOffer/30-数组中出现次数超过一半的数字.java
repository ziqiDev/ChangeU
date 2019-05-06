/*
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
*/
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length==0){
            return 0;
        }
        int number = findNumber(array);
        int count = 0;
        for(int index = 0;index<array.length;index++){
            if(number== array[index]){
                count ++;
            }
        }
        if(count*2> array.length){
            return number;
        }
        return 0;
    }
    
    public int findNumber(int[]array){
        int count = 1;
        int current = array[0];
        for(int index = 1;index<array.length;index++){
            if(current == array[index]){
                count++;
            }else{
                if(count==1){
                    current = array[index];
                }else{
                    count--;
                }
            }
        }
        return current;
    }
}
