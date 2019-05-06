/**
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
*/
import java.util.Arrays;
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre==null||pre.length<1){
            return null;
        }
        int first = pre[0];
        int index = findValue(in,first);
        int[] prefirst= Arrays.copyOfRange(pre,1,index+1);
        int[] preAfter = Arrays.copyOfRange(pre,index+1,pre.length);
        int[] inFirst = Arrays.copyOfRange(in,0,index);
        int[]inAfter = Arrays.copyOfRange(in,index+1,in.length);
        TreeNode left = reConstructBinaryTree(prefirst,inFirst);
        TreeNode right = reConstructBinaryTree(preAfter,inAfter);
        TreeNode res = new TreeNode(first);
        res.left = left;
        res.right = right;
        return res;
    }
    public int findValue(int[]in,int first){
        for(int index = 0;index<in.length;index++){
            if(in[index]==first){
                return index;
            }
        }
        return -1;
    }
}
