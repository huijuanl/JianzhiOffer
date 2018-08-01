package JianzhiOffer;
//定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数。
import java.util.Stack;

public class MinStack_21 {
    Stack<Integer>stack1 = new Stack<Integer>();
    Stack<Integer>stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
        if(!stack2.isEmpty()){
        	stack2.push(Math.min(node,stack2.peek()));
        }
        else stack2.push(node);
        
    }
    
    public void pop() {
    	stack1.pop();
        stack2.pop();
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int min() {
        return stack2.peek();
    }
}

