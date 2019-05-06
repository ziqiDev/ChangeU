/*
输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
*/
import java.util.ArrayList;
import java.util.TreeSet;
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str.length()==0){
            return res;
        }
        TreeSet<String> set = new TreeSet<>();
        permu(set,str.toCharArray(),0);
        return new ArrayList(set);
    }
    public void permu(TreeSet<String>list, char[] array, int start){
        if(start == array.length-1){
            list.add(String.valueOf(array));
        }
        for(int index = start;index<array.length;index++){
            swap(array, index, start);
            permu(list, array, start+1);
            swap(array, index, start);
            
        }
    }
    public void swap(char[] array, int start, int end){
        char temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }
}
