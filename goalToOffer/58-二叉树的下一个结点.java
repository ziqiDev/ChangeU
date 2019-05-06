/*
给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
*/
/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode root)
    {
        if(root==null){
            return null;
        }
        if(root.right!=null){
            root = root.right;
            while(root.left != null){
                root = root.left;
            }
            return root;
        }
        while(root.next !=null &&root.next.left!=root){
                    root = root.next;
                }
                return root.next;

    }
}
