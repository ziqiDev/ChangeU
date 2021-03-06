/*
请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
*/
public class Solution {
    public boolean match(char[] str, char[] pattern)
    {
        if(str==null||pattern == null){
            return false;
        }
        if(str.length==1){
            if(pattern.length==1){
                if(str[0]==pattern[0]||pattern[0]=='.'){
                    return true;
                }
                return false;
            }
        }
        int sindex = 0;
        int pindex = 0;
        return matchIndex(str, sindex,pattern,pindex);
    }
    public boolean matchIndex(char[]str,int sindex,char[]pattern,int pindex){
        if(sindex==str.length&&pindex==pattern.length){
            return true;
        }
        if(sindex != str.length&&pindex==pattern.length){
            return false;
        }
        if(pindex+1<pattern.length&& pattern[pindex+1] =='*'){
            if(sindex!=str.length&&pattern[pindex]==str[sindex]||sindex!=str.length&&pattern[pindex]=='.'){
                return matchIndex(str,sindex+1,pattern,pindex+2)||
                    matchIndex(str,sindex,pattern,pindex+2)||
                    matchIndex(str,sindex+1,pattern,pindex);
            }else{
                return matchIndex(str,sindex, pattern,pindex+2);
            }
        }
        if(sindex!=str.length&&pattern[pindex]==str[sindex]||sindex!=str.length&&pattern[pindex]=='.'){
            return matchIndex(str,sindex+1,pattern,pindex+1);
        }
        return false;
    }
}
