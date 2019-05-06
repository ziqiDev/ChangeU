/*
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
*/
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence ==null||sequence.length == 0){
            return false;
        }
        return verify(sequence,0, sequence.length-1);
    }
    
    public boolean verify(int[]array, int start, int end){
        boolean res = true;
        if(start>=end){
            return res;
        }
        int index ;
        for(index = start;index<end;index++){
            if(array[index]>array[end]){
                break;
            }
        }
        int split = index;
        for(;index<end;index++){
            if(array[index]<array[end]){
                res =  false;
                break;
            }
        }
        return res && verify(array,start,split-1) && verify(array,split,end-1);

    }
}
