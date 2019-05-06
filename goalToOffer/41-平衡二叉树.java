/*
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
*/
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        return isBalance(root);        
    }
    
    public boolean isBalance(TreeNode root){
        if(root==null){
            return true;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        int diff =left-right;
        if(diff<=1&&diff>=-1){
            return isBalance(root.left)&&isBalance(root.right);
        }
        return false;
    }
    
    public int getDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return left>right? left+1:right+1;
    }
    
}
