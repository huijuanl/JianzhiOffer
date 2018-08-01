package JianzhiOffer;

public class ReverseSingleList_16 {
	public static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	  public ListNode ReverseList(ListNode head) {
		     ListNode pre = null;
		     ListNode cur = head;
		     ListNode next;
		     while(cur!=null){
		         next = cur.next;
		         cur.next = pre;
		         pre =cur;
		         cur = next;
		         
		     }
		    return pre;
		    }
}
