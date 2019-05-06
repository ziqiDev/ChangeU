/**
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if(matrix == null){
            return res;
        }
        int column = matrix[0].length;
        int row = matrix.length;
        int left = 0;
        int right = column-1;
        int low =0;
        int high = row-1;
        
        while(left<=right&& low<=high){
            print(matrix,left,right,low,high,res);
            left++;
            right--;
            low++;
            high--;
        }
        return res;
    }
    public void print(int[][]matrix, int left,int right,int low,int high,ArrayList<Integer>res){
        for(int index = left;index<=right;index++){
            res.add(matrix[low][index]);
        }
        for(int index = low+1;index<=high;index++){
            res.add(matrix[index][right]);
        }
        if(low<high){
            for(int index = right-1;index>=left;index--){
                res.add(matrix[high][index]);
            }
        }
        if(left<right){
            for(int index = high-1;index>low;index--){
                res.add(matrix[index][left]);
            } 
        }
    }
}
