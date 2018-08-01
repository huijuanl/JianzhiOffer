package JianzhiOffer;
//输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
public class MergeList_17 {
	public static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	public static ListNode Merge(ListNode list1,ListNode list2) {
		 if(list1==null||list2==null)
	        return list1==null?list2:list1;
	        ListNode head;
	        ListNode tail;
	        ListNode another1;
	        ListNode another2;
	        if(list1.val<list2.val){
	            head = list1;
	            another2 = list2;
	            another1 = list1.next;
	          }
	        else{
	           head = list2; 
	           another2 = list1;
	           another1 = list2.next;
	         }
	        tail = head;
	        
	        while(another1!=null&&another2!=null){//注意这里是&&不是||
	        if(another1.val<another2.val){
	            tail.next = another1;
	            another1 = another1.next;
               tail =tail.next;
	          }
	        else{
	           tail.next = another2;
	            another2 = another2.next;
               tail =tail.next;
	         }
	        }
           tail.next = another1==null?another2:another1;
               
	        return head;
	        
	     }
	 public static void printLinkedList(ListNode head) {
	        System.out.print("Linked List without HeadNode: ");
	        while (head != null) {
	            System.out.print(head.val + " ");
	            head = head.next;
	        }
	        System.out.println();
	    }
	 public static void main(String[] args) {
		    ListNode head1 = new ListNode(1);
	        head1.next = new ListNode(3);
	        head1.next.next = new ListNode(5);
	        printLinkedList(head1);
	        ListNode head2 = new ListNode(2);
	        head2.next = new ListNode(4);
	        head2.next.next = new ListNode(6);
	        printLinkedList(head2);
	        ListNode head = Merge(head1,head2);
	        printLinkedList(head);

	    }
	
	
}
