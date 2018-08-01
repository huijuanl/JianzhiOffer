package JianzhiOffer;

import java.util.Stack;
//输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
//假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列
//但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
//关于栈有一个很有用的性质，对于出栈序列的每一个元素，该元素后  比该元素先入栈的一定按照降序排列。(这个时间复杂度比较高)
//我们用的是利用一个辅助栈模拟出栈入栈过程来进行
//建立一个辅助栈，同时给定两个指针a,b:a指向下一个要Push的元素,b表示下一个要pop的元素(这两个指针都不会回退)
//当需要比较的剩下的出栈序列不为空时，执行如下循环:
//(1)当栈为空同时还有可以push的元素时push一个元素入栈
//(2)如果下一个要弹出的元素与理想出栈序列希望的元素相同，那么直接出栈
//(3)如果下一个要弹出的元素与理想出栈序列希望的元素不同，
//   依次push剩下的元素直到栈顶元素与下一个出栈元素相同
//   如果发现push了之后所有的元素仍然没有找到相等的元素，直接返回false
//(4)循环结束之后,返回true
public class isStackPopOrder_22 {
    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {3,5,4,1,2};
        isStackPopOrder_22 it = new isStackPopOrder_22();
        System.out.println(it.IsPopOrder(pushA, popA));

    }

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<Integer>();
        int a = 0;//下一个要Push的元素下标
        int b = 0;//下一个要比较的pop元素下标
        while (b < popA.length) {
            //当栈为空同时还有可以push的元素时push一个元素入栈
            if(stack.isEmpty()&&a<popA.length){
                stack.push(pushA[a]);
                a++;
            }
            //如果下一个要弹出的元素与理想出栈序列希望的元素相同，那么直接出栈，同时b++
            if(stack.peek()==popA[b]){
                b++;
                stack.pop();
                continue;
            }
            //如果下一个要弹出的元素与理想出栈序列希望的元素不同，
            //依次push剩下的元素并判断push之后栈顶的元素是否与理想序列的下一个出栈元素相同
            //如果发现push了之后所有的元素仍然没有找到相等的元素，直接返回false
            while (stack.peek() != popA[b]) {
                if (a < pushA.length) {
                    stack.push(pushA[a]);
                    a++;
                } else {
                    return false;
                }
            }
            b++;
            stack.pop();
        }
        return true;
    }
}
