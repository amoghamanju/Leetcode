/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        int carry=0;
        while(l1!=null|| l2!=null||carry!=0)
        {
            int dg1=(l1!=null)?l1.val:0;
            int dg2=(l2!=null)?l2.val:0;

            int sum=dg1+dg2+carry;
            int dg=sum%10;
            carry=sum/10;

            ListNode newnode=new ListNode(dg);
            tail.next=newnode;
            tail=tail.next;

            l1=(l1!=null)?l1.next:null;
            l2=(l2!=null)?l2.next:null;
        }
        ListNode result=dummy.next;
        dummy.next=null;
        return result;
        
    }
}