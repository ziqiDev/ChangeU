/*
输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
*/

public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2 == null||root1 ==null){
            return false;
        }
        boolean res = false;
        if(root1.val == root2.val){
            res = isSubTree(root1, root2);
        }
        return res || HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
    }
    public boolean isSubTree(TreeNode root1, TreeNode root2){
        if(root2 == null ){
            return true;
        }
        if(root1 == null){
            return false;
        }
        if(root1.val == root2.val){
            return isSubTree(root1.left,root2.left)&& isSubTree(root1.right,root2.right);
        }
        return false;
    }
}
