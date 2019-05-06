/*
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
*/
import java.util.ArrayList;
public class Solution {
    public int[] multiply(int[] A) {
        int length = A.length;
        int pre[] = new int[length];
        int last[] = new int[length];
        pre[0] = 1;
        last[length-1] = 1;
        for(int i = 0;i<length-1;i++){
            pre[i+1] = pre[i]*A[i];
        }
        for(int i = length-1;i>0;i--){
            last[i-1] = last[i]*A[i];
        }
        int[]res = new int[length];
        for(int i = 0;i<length;i++){
            res[i] = pre[i]*last[i];
        }
        return res;
    }
}
