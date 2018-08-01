package JianzhiOffer;
//输入两个链表，找出它们的第一个公共结点。
public class findFirstCommonNode_37 {
    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null)
            return null;
        boolean isLoop1 = isLoopList(pHead1);
        boolean isLoop2 = isLoopList(pHead2);
        if(!isLoop1&&!isLoop2)
            return FindInNoLoopList(pHead1,pHead2);
        else if(isLoop1&&isLoop2)
            return FindInLoopList(pHead1,pHead2);
        else
            return null;
    }

    public boolean isLoopList(ListNode pHead){
        if(pHead==null||pHead.next==null)
            return false;
        ListNode quick = pHead.next.next;
        ListNode slow =pHead.next;
        while (slow!=quick){
            if(quick==null||quick.next==null)
                return false;
            slow =slow.next;
            quick = quick.next.next;
        }
        return true;
    }
    public ListNode FindInNoLoopList(ListNode pHead1, ListNode pHead2){
        ListNode cur = pHead1;
        int len = 0;
        while (cur!=null){
            len++;
            cur = cur.next;
        }
        cur = pHead2;
        while (cur!=null){
            len--;
            cur = cur.next;
        }
        ListNode head1 = pHead1;
        ListNode head2 = pHead2;
        while (len>0){
            head1 = head1.next;
            len--;
        }
        while (len<0){
            head2 = head2.next;
            len++;
        }
        while (head1!=head2){
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
    }
    public ListNode FindFirstNodeInLoopList(ListNode pHead){
        ListNode quick = pHead.next.next;
        ListNode slow = pHead.next;
        while (quick!=slow){
            slow = slow.next;
            quick = quick.next.next;
        }
        quick = pHead;
        while (slow!=quick){
            slow=slow.next;
            quick=quick.next;
        }
        return quick;

    }
    public ListNode FindInLoopList(ListNode pHead1, ListNode pHead2){
        ListNode first1 = FindFirstNodeInLoopList(pHead1);
        ListNode first2 = FindFirstNodeInLoopList(pHead2);
        if(first1==first2){
            int len =0;
            ListNode cur = pHead1;
            while (cur!=first1){
                len++;
                cur =cur.next;
            }
            cur = pHead2;
            while (cur!=first1){
                len--;
                cur =cur.next;
            }
            while (len>0){
                pHead1 = pHead1.next;
                len--;
            }
            while (len<0){
                pHead2 = pHead2.next;
                len++;
            }
            while (pHead1!=pHead2){
                pHead1=pHead1.next;
                pHead2=pHead2.next;
            }
            return pHead1;
        }
        ListNode cur = first1;
        while (cur.next!=first1){
            cur=cur.next;
            if(cur == first2)
                return first2;

        }
        return null;
    }
    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);

        // 0->9->8->6->7->null
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        findFirstCommonNode_37 it =new findFirstCommonNode_37();
//        System.out.println(it.FindFirstCommonNode(head1, head2).val);

        // 1->2->3->4->5->6->7->4...
        head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2->3->4->5->6->7->4...
        head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(it.FindFirstCommonNode(head1, head2).val);//2

        // 0->9->8->6->7->4->5->6->..
        head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(it.FindFirstCommonNode(head1, head2).val);

        // 0->9->8->6->8 不相交
//        head2 = new ListNode(0);
//        head2.next = new ListNode(9);
//        head2.next.next = new ListNode(8);
//        head2.next.next.next = new ListNode(6);
//        head2.next.next.next.next = head2.next.next;
//        System.out.println(it.FindFirstCommonNode(head1, head2));
    }
}
