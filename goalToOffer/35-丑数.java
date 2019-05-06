/*
把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
*/

public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index < 1){
            return 0;
        }
        if(index ==1){
            return 1;
        }
        int pre1 = 0;
        int pre2 =0;
        int pre3= 0;
        int []num = new int [index];
        num[0] = 1;
        for(int count = 1;count< index;count++){
            num[count]= min(num[pre1]*2,num[pre2]*3,num[pre3]*5);
            if(num[count] ==num[pre1]*2 ){
                pre1++;
            }
            if(num[count] ==num[pre2]*3){
                pre2++;
            }
            if(num[count] ==num[pre3]*5){
                pre3++;
            }
        }
        return num[index-1];
    }
    public int min(int number1, int number2,int number3){
        int min = number1 < number2? number1 : number2;
        min = min<number3? min:number3;
        return min;
    }
}
