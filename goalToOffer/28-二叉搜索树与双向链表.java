/*
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。

*/
public class Solution {
    public TreeNode Convert(TreeNode root) {
        TreeNode lastList = convertNode(root,null);
        while(lastList !=null&&lastList.left != null){
            lastList = lastList.left;
        }
        return lastList;
    }
    public TreeNode convertNode(TreeNode root,TreeNode lastList){
        if(root == null){
            return null;
        }
        if(root.left != null){
            lastList = convertNode(root.left, lastList);
        }
        root.left = lastList;
        if(lastList != null){
            lastList.right = root;
        }
        lastList = root;
        if(root.right!= null){
            lastList = convertNode(root.right, lastList);
        }
        return lastList;
    }
}
