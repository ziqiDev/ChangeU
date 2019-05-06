/*
一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
*/
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int orRes = array[0];
        for(int index = 1;index<array.length;index++){
            orRes = orRes^array[index];
        }
        for(int index = 0;index<array.length;index++){
            if(orRes == (orRes&array[index])){
                num1[0] = num1[0]^array[index];
            }else{
                num2[0] = num2[0]^array[index];
            }
        }
    }
}
