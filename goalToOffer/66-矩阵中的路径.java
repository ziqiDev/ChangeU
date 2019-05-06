/*
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
*/
public class Solution {
    public boolean hasPath(char[] str, int rows, int cols, char[] matrix)
    {
        int[][]flags = new int[rows][cols];
        boolean res = false;
        for(int row = 0;row<rows;row++){
            for(int col = 0;col<cols;col++){
                if(matrix[0]==str[row*cols+col]){
                    res = res || helper(matrix,rows,cols,str,flags,row,col,0);
                }
            }
        }
        return res;
    }
    public boolean helper(char[]matrix, int rows, int cols, char[]str,int[][]flags,
                          int row,int col,int length){
        if(length== matrix.length){
            return true;
        }
        if(row>=rows||col>=cols||row<0||col<0||flags[row][col]==1){
            return false;
        }
        boolean hasPath= false;
        if(matrix[length]== str[row*cols+col]){
            flags[row][col]=1;
            hasPath= helper(matrix,rows,cols,str,flags,row,col+1,length+1)||
                helper(matrix,rows,cols,str,flags,row,col-1,length+1)||
                helper(matrix,rows,cols,str,flags,row+1,col,length+1)||
                helper(matrix,rows,cols,str,flags,row-1,col,length+1);
            if(!hasPath){
                flags[row][col]=0;
            }
        }
        return hasPath;
    }
    


}
