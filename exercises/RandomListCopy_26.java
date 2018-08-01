package JianzhiOffer;
//输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
//另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
//（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
//1、复制每个节点，如：复制节点A得到A1，将A1插入节点A后面
//2、遍历链表，A1->random = A->random->next;
// 3、将链表拆分成原链表和复制后的链表
public class RandomListCopy_26 {
    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        RandomListNode cur = pHead;
        //复制，1-1'-2-2'.....
        while (cur != null) {
            RandomListNode curCopy = new RandomListNode(cur.label);
            RandomListNode next = cur.next;
            cur.next = curCopy;
            curCopy.next = next;
            cur = next;
        }
        //串random指针
        cur = pHead;
        while (cur != null) {
            if (cur.random != null)
                cur.next.random = cur.random.next;
            else cur.next.random = null;
            cur = cur.next.next;
        }
        RandomListNode copyHead = pHead.next;
        cur = pHead;
        //拆分链表
        while (cur.next != null) {
            RandomListNode thisNext = cur.next;
            cur.next = cur.next.next;
            cur = thisNext;
        }
        return copyHead;
    }

    public static void printRandLinkedList(RandomListNode head) {
        RandomListNode cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.label + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.random == null ? "- " : cur.random.label + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RandomListNode head = null;
        RandomListNode res1 = null;
        RandomListNode res2 = null;
//        printRandLinkedList(head);
        RandomListCopy_26 it = new RandomListCopy_26();
//        res1 = it.Clone(head);
//        printRandLinkedList(res1);
//        res2 = it.Clone(head);
//        printRandLinkedList(res2);
//        printRandLinkedList(head);
//        System.out.println("=========================");

        head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.next.next.next = new RandomListNode(4);
        head.next.next.next.next = new RandomListNode(5);
        head.next.next.next.next.next = new RandomListNode(6);

        head.random = head.next.next.next.next.next; // 1 -> 6
        head.next.random = head.next.next.next.next.next; // 2 -> 6
        head.next.next.random = head.next.next.next.next; // 3 -> 5
        head.next.next.next.random = head.next.next; // 4 -> 3
        head.next.next.next.next.random = null; // 5 -> null
        head.next.next.next.next.next.random = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = it.Clone(head);
        printRandLinkedList(res1);
        res2 = it.Clone(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

    }
}
