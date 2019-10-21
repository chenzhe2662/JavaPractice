public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if(l1==null){
                return l2;
            }
            if(l2==null){
                return l1;
            }
            ListNode cur1 = l1;
            ListNode cur2 = l2;
            ListNode newHead = new ListNode(-1);
            ListNode newTail = newHead;
            while(cur1!=null&&cur2!=null){
                if((cur1.val+cur2.val)>=10){
                        newTail.next = new ListNode((cur1.val+cur2.val)-10);
                        newTail=newTail.next;
                        cur1.next.val+=1;
                }else{
                    newTail.next = new ListNode(cur1.val+cur2.val);
                    newTail=newTail.next;
                }
                cur1=cur1.next;
                cur2=cur2.next;
            }
            if(cur1.next==null){
                if(cur2.val>=10){
                    newTail.next = new ListNode(cur2.val-10);
                    newTail=newTail.next;
                    cur2.next.val+=1;
                }else{
                    newTail.next=cur2;
                }

            }
            if(cur2.next==null){
                if(cur1.val>=10){
                    newTail.next = new ListNode(cur1.val-10);
                    newTail=newTail.next;
                    cur1.next.val+=1;
                }else{
                    newTail.next=cur1;
                }

            }
            return newHead.next;
        }
    }

