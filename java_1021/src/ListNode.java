
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
        class Solution {
            public ListNode reverseBetween(ListNode head, int m, int n) {
                if (head == null ) {
                    return null;
                }
                if (head.next == null) {
                    return head;
                }
                ListNode cur = head;
                ListNode prev = new ListNode(-1);

                for (int i = 0; i < m - 1; i++) {
                    prev = cur;
                    cur = cur.next;
                }
                ListNode newHead = cur;
                ListNode newTail = head;
                for (int i = 0; i < n - 1; i++) {
                    newTail = newTail.next;
                }
                newHead.next = newTail.next;
                prev.next = newTail;
                return head;
            }
        }
