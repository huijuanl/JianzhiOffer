package JianzhiOffer;
import java.util.*;
//输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
public class printFromTailTohead_5 {
	public class ListNode {
		       int val;
		       ListNode next = null;
	           ListNode(int val) {
		         this.val = val;
		      }
		  }
	//用栈来实现（时间开销少）。反转链表有点复杂（空间开销少）
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    
        Stack<Integer>stack = new Stack<Integer>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        ArrayList<Integer>arr = new ArrayList<Integer>();
        while(!stack.isEmpty()){
        	  arr.add(stack.pop());
        }
      return arr;
    }
}
