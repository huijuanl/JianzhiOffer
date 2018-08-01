package JianzhiOffer;
import java.util.*;
//输入一个链表，输出该链表中倒数第k个结点。
public class findKthToTail_15 {
	
	public static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	    //用栈
	    public ListNode FindKthToTail1(ListNode head,int k) {

	        Stack<ListNode>stack = new Stack<ListNode>();
	        int m=0;
	        while(head!=null){
	            stack.push(head);
	            head=head.next;
	            m++;
	        }
	        if(k<=0||m<k)
	            return null;
	        int i =1;
	        while(!stack.isEmpty()&&i<k){
	              i++;
	              stack.pop();   
	        }
	        return  stack.pop();
	    }
	    //不用栈
	    //设置两个指针，p2指针先走（k-1）步，然后再一起走，当p2为最后一个时，p1就为倒数第k个 数
	    public ListNode FindKthToTail2(ListNode head,int k) {
	    	if(head==null||k<=0)
	    		return null;
	    	ListNode slow = head;
	    	ListNode quick = head;
	    	int i = 1;
	    	while(quick!=null&&i!=k){
	    		quick=quick.next;
	    		i++;
	    	}
	    	if(quick==null)
	    		return null;
	    	while(quick.next!=null){
	    		quick=quick.next;
	    		slow = slow.next;
	    	}
	    	return slow;
	    }
}
