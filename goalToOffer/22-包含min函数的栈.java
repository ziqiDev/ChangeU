/*
定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））
*/
import java.util.Stack;

public class Solution {
    Stack<Integer> origin = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    public void push(int x) {
        if(origin.isEmpty()||min.peek()>=x){
            min.push(x);
        }
        origin.push(x);
    }
    
    public void pop() {
        if(min.peek().equals(origin.pop())){
            min.pop();
        }
    }
    
    public int top() {
        return origin.peek();
    }
    
    public int min() {
        return min.peek();
    }
}
