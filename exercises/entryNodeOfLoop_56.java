package JianzhiOffer;
//给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
public class entryNodeOfLoop_56 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead==null||pHead.next==null)
            return null;
        ListNode slow = pHead.next;
        ListNode quick = slow.next;
        while (quick!=slow){
            if(quick==null)
                return null;
            quick=quick.next.next;
            slow=slow.next;

        }
        while (pHead!=quick){
            pHead = pHead.next;
            quick = quick.next;
        }
        return pHead;
    }
}
