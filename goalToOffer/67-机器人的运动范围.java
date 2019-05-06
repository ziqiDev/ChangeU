/*
地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
*/
public class Solution {
    public int movingCount(int threshold, int rows, int cols)
    {    
        int[][]flags = new int[rows][cols];
        return moving(0,0,rows,cols,threshold,flags);
    }
    
    public int moving(int row,int col,int rows,int cols,int threshold, int [][]flags){
        if(row<0||col<0||row>=rows||col>=cols|| !isAccess(col,row,threshold)||flags[row][col]==1){
            return 0;
        }
        flags[row][col] =1;
        return 1+moving(row,col-1,rows,cols,threshold,flags)
            +moving(row,col+1,rows,cols,threshold,flags)
            +moving(row+1,col,rows,cols,threshold,flags)
            +moving(row-1,col,rows,cols,threshold,flags);
    }
    
    public boolean isAccess(int col,int row, int threshold){
        int sum = 0;
        sum += sumNum(col);
        sum += sumNum(row);
        return threshold>=sum;
    }
    
    public int sumNum(int num){
        int sum = 0;
        while(num>0){
            sum += num%10;
            num /=10;
        }
        return sum;
    }
}
