/**
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
n<=39
*/
public class Solution {
    public int Fibonacci(int n) {
        int res = 0;
        int pre = 0;
        int last = 1;
        if(n == 0){
            return pre;
        }
        if(n==1){
            return last;
        }
        for(int index = 2;index<=n;index++){
            res = pre + last;
            pre = last;
            last = res;
        }
        return res;
    }
}
