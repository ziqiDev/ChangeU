/*

请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
*/
public class Solution {
    public boolean isNumeric(char[] str) {
        if(str==null){
            return false;
        }
        int index = 0;
        int count = 0;
        int point = 0;
        if(str[0]=='-'||str[0]=='+'){
            index ++;
        }
        for(int i = index;i<str.length;i++){
            if(str[i]=='-'||str[i]=='+'){
                if(str[i-1]!='e'&&str[i-1]!='E'){
                    return false;
                }
                continue;
            }
            if(str[i]=='e'||str[i]=='E'){
                count++;
                if(count>1){
                    return false;
                }
                if(i==0||str[i-1]<48||str[i-1]>57||i==str.length-1){
                    return false;
                }
                point++;
                continue;
            }
            if(str[i]=='.'){
                point++;
                if(point>1){
                    return false;
                }
                continue;
            }
            if((str[i]<48||str[i]>57)&&(str[i]!='e')&&(str[i]!='E')){
                return false;
            }
        }
        return true;
    }
}
