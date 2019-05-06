/*
输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
*/
import java.util.ArrayList;
public class Solution {
    private ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null){
            return paths;
        }
        findPath(root,0,target,new ArrayList<Integer>());
        return paths;
    }
    public void findPath(TreeNode root, int currentSum,int target,ArrayList<Integer> treeNodes){
        currentSum += root.val;
        treeNodes.add(root.val);
        if(root.left==null && root.right==null&& currentSum==target){
            insertArray(this.paths, new ArrayList(treeNodes));
            
        }
        if(root.left != null){
             findPath(root.left,currentSum,target,treeNodes);   
        }
        if(root.right != null){
             findPath(root.right,currentSum,target,treeNodes);   
        }
        treeNodes.remove(Integer.valueOf(root.val));
    }
    public void insertArray(ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> treeNodes){
        if(paths.isEmpty()){
            paths.add(treeNodes);
            return;
        }
        int size = treeNodes.size();
        for(int index = 0;index <paths.size();index++){
            if(size>= paths.get(index).size()){
                paths.add(index, treeNodes);
                return;
            }
        }
        paths.add(treeNodes);
    }
}

