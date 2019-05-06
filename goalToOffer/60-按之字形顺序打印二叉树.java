/*
请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
*/
public class Solution {
    public ArrayList<ArrayList<Integer> > Print(TreeNode root) {
        ArrayList<ArrayList<Integer> > res = new ArrayList<ArrayList<Integer> >();
        if(root == null){
            return res;
        }
        Deque <Integer> deque = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 1;
        int preSize = 1;
        int size = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            preSize--;
            if(node.left!=null){
                size++;
                queue.offer(node.left);
            }
            if(node.right!=null){
                size++;
                queue.offer(node.right);
            }
            if(level%2==1){
                deque.offer(node.val);
            }else{
                deque.offerFirst(node.val);
            }
            if(preSize==0){
                res.add(new ArrayList<Integer>(deque));
                deque.clear();
                preSize = size;
                size = 0;
                level++;
            }
        }
        return res;
    }

}
