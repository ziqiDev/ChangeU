/*
在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）
*/
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if(str==null || str.length()==0){
            return -1;
        }
        int [] records = new int[256];
        for(int i = 0;i<str.length();i++){
            int number = str.charAt(i)- '0';
            records[number]++;
        }
        for(int i = 0;i<str.length();i++){
            int number = str.charAt(i)- '0';
            if(records[number]==1){
                return i;
            }
        }
        return -1;
    }
}
