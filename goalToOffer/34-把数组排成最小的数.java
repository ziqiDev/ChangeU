/*
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String PrintMinNumber(int [] nums) {
        String res = "";
        if(nums == null||nums.length==0){
            return res;
        }
        String[]strs = new String[nums.length];
        for(int i = 0;i<nums.length;i++){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer i1 = Integer.valueOf(o1.concat(o2));
                Integer i2 = Integer.valueOf(o2.concat(o1));
                return i1-i2;
            }
        });
        for(int index = 0;index<strs.length;index++){
            res = res.concat(strs[index]);
        }
        return res;
    }    
}
