/*
题目描述
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

*/
public class Solution {
    public boolean Find(int target, int [][] array) {
        boolean res = false;
        if(array==null|| array.length==0)
            return res;
        int columns = array[0].length;
        int rows = array.length;
        int i = columns-1;
        int j=0;
        while(j<=rows-1&&i>=0){
            if(array[j][i]==target){
                res = true;
                break;
            }else if(array[j][i]<target){
                j++;
            }else{
                i--;
            }
        }
        return res;
    }
}



