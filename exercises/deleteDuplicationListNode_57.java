package JianzhiOffer;
//在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
// 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
// 思路：用三个指针来解决
// pre：上一个没有重复的节点
//cur:当前比较的节点
//quick;下一个不与cur重复的节点
//注意首尾的特殊处理
public class deleteDuplicationListNode_57 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null)
            return null;
        ListNode cur = pHead;
        ListNode pre = null;
        while (cur != null) {
            ListNode quick = cur.next;
            Boolean hasSame = false;
            while (quick != null && quick.val == cur.val) {
                quick = quick.next;
                hasSame = true;
            }
            if (hasSame) {
                if (pre == null)
                    pHead = quick;
                else pre.next = quick;
                if (quick == null)
                    return pHead;
                cur = quick;
            } else {
                pre = cur;
                cur = quick;
            }
        }
        return pHead;
    }
}
