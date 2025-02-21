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
    public ListNode reverseKGroup(ListNode head, int k) {
        int cnt = k-1;
        ListNode curr = head;
        while(cnt>0 && curr != null){
            curr = curr.next;
            cnt--;
        }
        if(curr == null){
            return head;
        }


        ListNode remainingNodes = curr.next;
        curr.next = null;
        ListNode newNode = reverse(head);
        head.next = reverseKGroup(remainingNodes,k);
        return newNode;

    }
    public int getLength(ListNode head){
        int cnt=0;
        ListNode node = head;
        while(node != null){
            cnt++;
            node  = node.next;
        }
        return cnt;
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}