
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    //删除重复节点
    public ListNode removeElements(ListNode head, int val) {
        //空链表
        if (head == null) {
            return null;
        }
        //中间节点
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
                cur = prev.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        //头节点
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }

    //反转链表
    public ListNode reverseList(ListNode head) {
        //空链表
        if (head == null) {
            return null;
        }
        //只有一个节点
        if (head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode newHead = null;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return newHead;
    }

    //返回中间节点
    public ListNode middleNode(ListNode head) {
        int steps = size(head) / 2;
        ListNode cur = head;
        for (int i = 0; i < steps; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //找到倒数第k个节点
    public ListNode FindKthToTail(ListNode head, int k) {
        int len = size(head);
        if (k <= 0 || k > len || head == null) {
            return null;
        }
        ListNode cur = head;
        for (int i = 0; i < len - k; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public int size(ListNode head) {
        int size = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }

    //合并两个有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //有一个是空链表
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode newHead = null;
        ListNode newTail = null;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                if (newHead == null) {
                    newHead = cur1;
                    newTail = cur1;
                    cur1 = cur1.next;
                } else {
                    newTail.next = cur1;
                    newTail = newTail.next;
                    cur1 = cur1.next;
                }
            } else {
                if (newHead == null) {
                    newHead = cur2;
                    newTail = cur2;
                    cur1 = cur2.next;
                } else {
                    newTail.next = cur2;
                    newTail = newTail.next;
                    cur2 = cur2.next;
                }
            }
        }//end while
        if (cur1 == null) {
            newTail.next = cur2;
        }
        if (cur2 == null) {
            newTail.next = cur1;
        }
        return newHead;
    }

    //分割链表
    public ListNode partition(ListNode pHead, int x) {
        if (pHead == null) {
            return null;
        }
        if (pHead.next == null) {
            return pHead;
        }
        ListNode smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;
        ListNode bigHead = new ListNode(-1);
        ListNode bigTail = bigHead;
        for (ListNode cur = pHead; cur != null; cur = cur.next) {
            if (cur.val < x) {
                smallHead.next = new ListNode(cur.val);
                smallTail = smallTail.next;
            } else {
                bigHead.next = new ListNode(cur.val);
                bigTail = bigTail.next;
            }
        }
        smallTail.next = bigHead.next;
        return smallHead.next;
    }

    //删除所有重复元素
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
            } else {
                newTail.next = new ListNode(cur.val);
                newTail = newTail.next;
                cur = cur.next;
            }
        }
        return newHead.next;
    }

    //回文链表
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }
        ListNode newHead = head;
        int len = size(head) / 2;
        for (int i = 0; i < len; i++) {
            newHead = newHead.next;
        }
        ListNode cur = newHead;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        while (newHead != null) {
            if (newHead.val != head.val) {
                return false;
            }
            newHead = newHead.next;
            head = head.next;
        }
        return true;
    }

    //相交链表
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=size(headA);
        int lenB=size(headB);
        if(lenA<lenB){
            for (int i = 0; i < lenB-lenA; i++) {
                headB=headB.next;
            }
        }else {
            for (int i = 0; i < lenA-lenB; i++) {
                headA=headA.next;
            }
        }
        while(headA!=null&&headB!=null){
            if(headA==headB){
                return headA;
            }
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }
}
