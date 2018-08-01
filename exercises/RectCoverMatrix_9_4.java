package JianzhiOffer;
//我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
public class RectCoverMatrix_9_4 {
	public static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	 public static int RectCover(int target) {
		 if(target==1)
			 return 1;
		 if(target==2)
			 return 2;
		 int[]dp = new int[target+1];
		 dp[1]=1;
		 dp[2]=2;
		 for(int i=3;i<=target;i++){
			 dp[i]=dp[i-1]+dp[i-2];
			 
		 }
		 return dp[target];
	    }
	 public static void main(String[]args){
		 System.out.println(RectCover(3));
	 }
	 public ListNode Merge(ListNode list1,ListNode list2) {
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
	        
	        while(another1!=null||another2!=null){
	        if(another1.val<another2.val){
	            tail.next = another1;
	            another1 = another1.next;
	          }
	        else{
	           tail.next = another2;
	            another2 = another2.next;
	         }
	        }
	        return head;
	        
	     }
	    
}
