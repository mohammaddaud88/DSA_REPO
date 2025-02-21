/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null ||head.next == null){
            return head;
        }
        ListNode mid = getMid(head);
        ListNode node = mid.next;
        mid.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(node);
        
        return merge(left, right);
    }

    public ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!= null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode currNode = dummyHead;
        while (l1 != null && l2 != null) {
            if(l1.val > l2.val){
                currNode.next=l2;
                l2 = l2.next;
            } else {
                currNode.next=l1;
                l1 = l1.next;
            }
            currNode = currNode.next;
        }
        if(l1 != null){
            currNode.next = l1;
        }else {
            currNode.next = l2;
        }
        return dummyHead.next;
    }
}