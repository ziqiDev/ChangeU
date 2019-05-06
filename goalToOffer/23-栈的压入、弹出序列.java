/**
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
*/

import java.util.ArrayList;
import java.util.Stack;
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
      if(popA ==null||pushA ==null||pushA.length!=popA.length){
          return false;
      }
      Stack<Integer> stack = new Stack<Integer>();
        int count = 0;
      for(int index = 0;index < pushA.length;index++){
          if(pushA[index]==popA[count]){
              count++;
              while(!stack.isEmpty()&&stack.peek().equals(popA[count])){
                  count++;
                  stack.pop();
              }
          }else{
              stack.push(pushA[index]);
          }
          }
       if(count== popA.length){
           return true;
       }
        return false;
      
    }
}
