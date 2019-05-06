/*
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
*/
import java.util.*;
public class Solution {
    ArrayList<ArrayList<Integer> > Print(TreeNode root) {
        ArrayList<ArrayList<Integer> > res = new ArrayList<ArrayList<Integer> >();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int preSize = 1;
        int size = 0;
        queue.offer(root);
        ArrayList<Integer> here = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            preSize--;
            if(node.left!=null){
                queue.offer(node.left);
                size++;
            }
            if(node.right!=null){
                queue.offer(node.right);
                size++;
            }
            here.add(node.val);
            if(preSize ==0){
                res.add(new ArrayList<Integer>(here));
                here.clear();
                preSize = size;
                size=0;
            }
        }
        return res;
    }
    
}
